
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "urlkey",
    "topic_name"
})
public class GroupTopic {

    @JsonProperty("urlkey")
    private String urlkey;
    @JsonProperty("topic_name")
    private String topicName;

    @JsonProperty("urlkey")
    public String getUrlkey() {
        return urlkey;
    }

    @JsonProperty("urlkey")
    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    @JsonProperty("topic_name")
    public String getTopicName() {
        return topicName;
    }

    @JsonProperty("topic_name")
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

}
