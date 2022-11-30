package com.example.socialmeli2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersListResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followers")
    private List<UserBasicResponse> userBasicResponseList;

}
