package com.wordpress.simplydistributed.meetup.weboscket.client;

import com.wordpress.simplydistributed.meetup.weboscket.client.model.GroupTopic;
import com.wordpress.simplydistributed.meetup.weboscket.client.model.MeetupRSVP;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import redis.clients.jedis.Jedis;

public class MeetupRSVPsWebSocketClient extends Endpoint {
    private Jedis jedis;
    private static String LEADERBOARD_REDIS_KEY = "groups";
    private static Set<String> GROUPS_IN_REDIS = Collections.synchronizedSet(new HashSet<String>());

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("Server session established");
        //conn to redis
        jedis = new Jedis("192.168.99.100", 6379, 10000);
        session.addMessageHandler(new MessageHandler.Whole<MeetupRSVP>() {
            @Override
            public void onMessage(MeetupRSVP message) {
                List<GroupTopic> groupTopics = message.getGroup().getGroupTopics();
                for (GroupTopic groupTopic : groupTopics) {
                    try {
                        
                        if(GROUPS_IN_REDIS.contains(groupTopic.getTopicName())){
                            jedis.zincrby(LEADERBOARD_REDIS_KEY, 1, groupTopic.getTopicName());
                        }else{
                            //zscore = jedis.zscore(LEADERBOARD_REDIS_KEY, groupTopic.getTopicName());
                            jedis.zadd(LEADERBOARD_REDIS_KEY, 1, groupTopic.getTopicName());
                            GROUPS_IN_REDIS.add(groupTopic.getTopicName());
                        }

//                        Double zscore = jedis.zscore(LEADERBOARD_REDIS_KEY, groupTopic.getTopicName());;
//                        if(zscore == null){
//                            jedis.zadd(LEADERBOARD_REDIS_KEY, 1, groupTopic.getTopicName());
//                        }else{
//                            jedis.zincrby(LEADERBOARD_REDIS_KEY, 1, groupTopic.getTopicName());
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        });

    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        jedis.close();
        System.out.println("Redis connection closed");
    }

}
