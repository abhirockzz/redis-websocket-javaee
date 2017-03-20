package com.wordpress.simplydistributed.meetup.leaderboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordpress.simplydistributed.meetup.leaderboard.model.Leaderboard;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Singleton
@Startup
public class PingForLeaders {

    @Resource
    private TimerService ts;
    private Timer timer;
    private Jedis jedis;
    private static final String LEADERBOARD_REDIS_KEY = "groups";

    @PostConstruct
    public void init() {
        /**
         * fires 5 secs after creation interval = 5 secs non-persistent
         * no-additional (custom) info
         */
        timer = ts.createIntervalTimer(5000, 5000, new TimerConfig(null, false)); //trigger every 5 seconds
        Logger.getLogger(PingForLeaders.class.getName()).log(Level.INFO, "Timer initiated");
        jedis = new Jedis("192.168.99.100", 6379, 10000);

    }

    @Inject
    @LeaderDataQualifier
    private Event<String> msgEvent;

    private final ObjectMapper mapper = new ObjectMapper();

    @Timeout
    public void timeout(Timer timer) {
        Logger.getLogger(PingForLeaders.class.getName()).log(Level.INFO, "Timer fired at {0}", new Date());
        /**
         * find top 10 trending groups
         */
        Set<Tuple> zrangeByScoreWithScores = jedis.zrevrangeByScoreWithScores(LEADERBOARD_REDIS_KEY, Integer.MAX_VALUE, 1, 0, 10);
        
        Leaderboard lb = new Leaderboard();

        for (Tuple tuple : zrangeByScoreWithScores) {
            lb.add(tuple.getElement(), String.valueOf(tuple.getScore()));
        }
        String json = null;
        try {
            json = mapper.writeValueAsString(lb);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(PingForLeaders.class.getName()).log(Level.SEVERE, null, ex);
        }
        msgEvent.fire(json);
    }

    @PreDestroy
    public void close() {
        timer.cancel();
        jedis.close();
        Logger.getLogger(PingForLeaders.class.getName()).log(Level.INFO, "Application shutting down. Timer purged, Jedis client closed");
    }
}
