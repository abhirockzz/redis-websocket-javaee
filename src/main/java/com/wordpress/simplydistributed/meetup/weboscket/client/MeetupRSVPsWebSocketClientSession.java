package com.wordpress.simplydistributed.meetup.weboscket.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.Decoder;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@Singleton
@Startup
public class MeetupRSVPsWebSocketClientSession {
    Session session = null;
    
    @PostConstruct
    public void init(){
        try {
            WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
            List<Class<? extends Decoder>> decoders = new ArrayList<>();
            decoders.add(MeetupRSVPJSONDecoder.class);
            session = webSocketContainer.connectToServer(new MeetupRSVPsWebSocketClient(),
                    ClientEndpointConfig.Builder.create().decoders(decoders).build(),
                    URI.create("ws://stream.meetup.com/2/rsvps"));
        } catch (DeploymentException | IOException ex) {
            Logger.getLogger(MeetupRSVPsWebSocketClientSession.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    @PreDestroy
    public void close(){
        try {
            session.close();
            System.out.println("WebSocket Session closed");
        } catch (IOException ex) {
            Logger.getLogger(MeetupRSVPsWebSocketClientSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
