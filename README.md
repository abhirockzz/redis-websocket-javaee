This is an application which displays the currently trending Meetup groups based on their (live) RSVPs feed. It's built using Java EE. Uses WebSocket (both client & server APIs), (Singleton) EJB timers and CDI events to wire things up

## From Meetup to Redis

- A WebSocket client consumes live [Meetup RSVP feed](https://www.meetup.com/meetup_api/docs/stream/2/rsvps/#websockets) 
- It parses each RSVP pushes the groups related data to a Redis sorted set
- Uses [Jedis client](https://github.com/xetorthio/jedis/) for Redis and [Jackson](https://github.com/FasterXML/jackson) for POJO based JSON binding

## From Redis to live trends

Once the data is in a Redis sorted set

- A Singleton EJB polls Redis to get top 10 `Jedis#zrevrangeByScoreWithScores` groups as per data in the RSVPs
- The information is pushed to a WebSocket endpoint via CDI
- Redis sorted set does all the heavy-lifting: Java EE helps build the solution on top of all this
- The WebSocket endpoint is consumed from within a HTML file which is in turn accessed by the end user

## To run

- clone
- change Redis connection details [here](https://github.com/abhirockzz/redis-websocket-javaee/blob/master/src/main/java/com/wordpress/simplydistributed/meetup/leaderboard/PingForLeaders.java#L42) and [here](https://github.com/abhirockzz/redis-websocket-javaee/blob/master/src/main/java/com/wordpress/simplydistributed/meetup/weboscket/client/MeetupRSVPsWebSocketClient.java#L25)
- `mvn clean install`
- deploy the WAR file in any Java EE 7 (or above) compliant container
- browse to `http://<host:port>/meetup-trending/` e.g. `http://localhost:8080/meetup-trending/`

You should see something like this

[](https://abhirockzz.files.wordpress.com/2017/03/meetup-trending-groups1.jpg)

## Credits

- Inspiration was obtained [from here](https://luvit.io/blog/redis-client.html)
- I am terrible at front end.. yes, even the most simplest ones. So I picked up things [from here](https://github.com/YuriyGuts/redis-websocket-leaderboard)

## TODOs

- CDI Producer for `Jedis` client
- find other TODOs
