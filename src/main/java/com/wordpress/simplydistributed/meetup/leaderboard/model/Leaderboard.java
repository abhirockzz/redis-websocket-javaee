package com.wordpress.simplydistributed.meetup.leaderboard.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "leaderboard"
})
public class Leaderboard {

    @JsonProperty("leaderboard")
    private List<Leaderboard_> leaderboard = null;

    public Leaderboard() {
        leaderboard = new ArrayList<>();
    }
    
    


    @JsonProperty("leaderboard")
    public List<Leaderboard_> getLeaderboard() {
        return leaderboard;
    }

    @JsonProperty("leaderboard")
    public void setLeaderboard(List<Leaderboard_> leaderboard) {
        this.leaderboard = leaderboard;
    }

    public void add(String name, String score){
        leaderboard.add(new Leaderboard_(name, score));
    }
   
}
