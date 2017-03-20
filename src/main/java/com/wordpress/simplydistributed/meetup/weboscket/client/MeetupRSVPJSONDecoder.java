
package com.wordpress.simplydistributed.meetup.weboscket.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wordpress.simplydistributed.meetup.weboscket.client.model.MeetupRSVP;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class MeetupRSVPJSONDecoder implements Decoder.Text<MeetupRSVP>{
    
    static ObjectMapper mapper = new ObjectMapper()
                                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public MeetupRSVP decode(String s) throws DecodeException {
        MeetupRSVP meetupRSVP = null;
        try {
            meetupRSVP = mapper.readValue(s, MeetupRSVP.class);
        } catch (IOException ex) {
            Logger.getLogger(MeetupRSVPJSONDecoder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meetupRSVP;
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig config) {
        //no-op
    }

    @Override
    public void destroy() {
        //no-op
    }
    
}
