package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedPublicationResponse {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post")
    private List<PublicationResponse> publicationResponseList;
}
