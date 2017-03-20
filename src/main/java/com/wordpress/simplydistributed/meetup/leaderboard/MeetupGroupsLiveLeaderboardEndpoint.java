
package com.wordpress.simplydistributed.meetup.leaderboard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.SendHandler;
import javax.websocket.SendResult;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/live/")
public class MeetupGroupsLiveLeaderboardEndpoint {
    
    private static final List<Session> CLIENTS = new ArrayList<>();

    @OnOpen
    public void open(Session s) {
        CLIENTS.add(s);
        Logger.getLogger(MeetupGroupsLiveLeaderboardEndpoint.class.getName()).log(Level.INFO, "Client connected -- {0}", s.getId());
    }
    
    public void broadcast(@Observes @LeaderDataQualifier String leaderboard) {
        for (final Session s : CLIENTS) {
            if (s != null && s.isOpen()) {
                /**
                 * Asynchronous push
                 */
                s.getAsyncRemote().sendText(leaderboard, new SendHandler() {
                    @Override
                    public void onResult(SendResult result) {
                        if (result.isOK()) {
                            //Logger.getLogger(MeetupGroupsLiveLeaderboardEndpoint.class.getName()).log(Level.INFO, " sent to client {0}", s.getId());
                        } else {
                            Logger.getLogger(MeetupGroupsLiveLeaderboardEndpoint.class.getName()).log(Level.SEVERE, "Could not send to client " + s.getId(),
                                    result.getException());
                        }
                    }
                });
            }

        }

    }
    
    @OnClose
    public void close(Session s) {
        CLIENTS.remove(s);
        Logger.getLogger(MeetupGroupsLiveLeaderboardEndpoint.class.getName()).log(Level.INFO, "Client discconnected -- {0}", s.getId());
    }
}
