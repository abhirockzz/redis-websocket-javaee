
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venue_name",
    "lon",
    "lat",
    "venue_id"
})
public class Venue {

    @JsonProperty("venue_name")
    private String venueName;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("venue_id")
    private Integer venueId;

    @JsonProperty("venue_name")
    public String getVenueName() {
        return venueName;
    }

    @JsonProperty("venue_name")
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("venue_id")
    public Integer getVenueId() {
        return venueId;
    }

    @JsonProperty("venue_id")
    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

}
