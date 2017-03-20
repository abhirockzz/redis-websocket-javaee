package com.wordpress.simplydistributed.meetup.leaderboard.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "score"
})
public class Leaderboard_ {

    public Leaderboard_(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @JsonProperty("name")
    private String name;
    @JsonProperty("score")
    private String score;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

}
