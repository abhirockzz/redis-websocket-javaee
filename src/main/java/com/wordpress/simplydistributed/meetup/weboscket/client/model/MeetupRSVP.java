
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "venue",
    "visibility",
    "response",
    "guests",
    "member",
    "rsvp_id",
    "mtime",
    "event",
    "group"
})
public class MeetupRSVP {

    @JsonProperty("venue")
    private Venue venue;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("response")
    private String response;
    @JsonProperty("guests")
    private Integer guests;
    @JsonProperty("member")
    private Member member;
    @JsonProperty("rsvp_id")
    private Integer rsvpId;
    @JsonProperty("mtime")
    private Long mtime;
    @JsonProperty("event")
    private Event event;
    @JsonProperty("group")
    private Group group;

    @JsonProperty("venue")
    public Venue getVenue() {
        return venue;
    }

    @JsonProperty("venue")
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    @JsonProperty("guests")
    public Integer getGuests() {
        return guests;
    }

    @JsonProperty("guests")
    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    @JsonProperty("member")
    public Member getMember() {
        return member;
    }

    @JsonProperty("member")
    public void setMember(Member member) {
        this.member = member;
    }

    @JsonProperty("rsvp_id")
    public Integer getRsvpId() {
        return rsvpId;
    }

    @JsonProperty("rsvp_id")
    public void setRsvpId(Integer rsvpId) {
        this.rsvpId = rsvpId;
    }

    @JsonProperty("mtime")
    public Long getMtime() {
        return mtime;
    }

    @JsonProperty("mtime")
    public void setMtime(Long mtime) {
        this.mtime = mtime;
    }

    @JsonProperty("event")
    public Event getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(Event event) {
        this.event = event;
    }

    @JsonProperty("group")
    public Group getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(Group group) {
        this.group = group;
    }

}
