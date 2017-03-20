
package com.wordpress.simplydistributed.meetup.weboscket.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "member_id",
    "photo",
    "member_name"
})
public class Member {

    @JsonProperty("member_id")
    private Integer memberId;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("member_name")
    private String memberName;

    @JsonProperty("member_id")
    public Integer getMemberId() {
        return memberId;
    }

    @JsonProperty("member_id")
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("member_name")
    public String getMemberName() {
        return memberName;
    }

    @JsonProperty("member_name")
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

}
