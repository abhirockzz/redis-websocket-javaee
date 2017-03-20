
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "group_topics",
    "group_city",
    "group_country",
    "group_id",
    "group_name",
    "group_lon",
    "group_urlname",
    "group_state",
    "group_lat"
})
public class Group {

    @JsonProperty("group_topics")
    private List<GroupTopic> groupTopics = null;
    @JsonProperty("group_city")
    private String groupCity;
    @JsonProperty("group_country")
    private String groupCountry;
    @JsonProperty("group_id")
    private Integer groupId;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("group_lon")
    private Double groupLon;
    @JsonProperty("group_urlname")
    private String groupUrlname;
    @JsonProperty("group_state")
    private String groupState;
    @JsonProperty("group_lat")
    private Double groupLat;

    @JsonProperty("group_topics")
    public List<GroupTopic> getGroupTopics() {
        return groupTopics;
    }

    @JsonProperty("group_topics")
    public void setGroupTopics(List<GroupTopic> groupTopics) {
        this.groupTopics = groupTopics;
    }

    @JsonProperty("group_city")
    public String getGroupCity() {
        return groupCity;
    }

    @JsonProperty("group_city")
    public void setGroupCity(String groupCity) {
        this.groupCity = groupCity;
    }

    @JsonProperty("group_country")
    public String getGroupCountry() {
        return groupCountry;
    }

    @JsonProperty("group_country")
    public void setGroupCountry(String groupCountry) {
        this.groupCountry = groupCountry;
    }

    @JsonProperty("group_id")
    public Integer getGroupId() {
        return groupId;
    }

    @JsonProperty("group_id")
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("group_name")
    public String getGroupName() {
        return groupName;
    }

    @JsonProperty("group_name")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @JsonProperty("group_lon")
    public Double getGroupLon() {
        return groupLon;
    }

    @JsonProperty("group_lon")
    public void setGroupLon(Double groupLon) {
        this.groupLon = groupLon;
    }

    @JsonProperty("group_urlname")
    public String getGroupUrlname() {
        return groupUrlname;
    }

    @JsonProperty("group_urlname")
    public void setGroupUrlname(String groupUrlname) {
        this.groupUrlname = groupUrlname;
    }

    @JsonProperty("group_state")
    public String getGroupState() {
        return groupState;
    }

    @JsonProperty("group_state")
    public void setGroupState(String groupState) {
        this.groupState = groupState;
    }

    @JsonProperty("group_lat")
    public Double getGroupLat() {
        return groupLat;
    }

    @JsonProperty("group_lat")
    public void setGroupLat(Double groupLat) {
        this.groupLat = groupLat;
    }

}
