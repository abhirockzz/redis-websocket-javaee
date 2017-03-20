
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "event_name",
    "event_id",
    "time",
    "event_url"
})
public class Event {

    @JsonProperty("event_name")
    private String eventName;
    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("time")
    private Long time;
    @JsonProperty("event_url")
    private String eventUrl;

    @JsonProperty("event_name")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty("event_name")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @JsonProperty("event_id")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("event_id")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("time")
    public Long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Long time) {
        this.time = time;
    }

    @JsonProperty("event_url")
    public String getEventUrl() {
        return eventUrl;
    }

    @JsonProperty("event_url")
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

}
