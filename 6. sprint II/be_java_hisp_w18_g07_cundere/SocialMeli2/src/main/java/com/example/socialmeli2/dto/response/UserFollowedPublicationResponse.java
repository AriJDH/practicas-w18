package com.example.socialmeli2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedPublicationResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post")
    private List<PublicationResponse> publicationResponseList;

}
