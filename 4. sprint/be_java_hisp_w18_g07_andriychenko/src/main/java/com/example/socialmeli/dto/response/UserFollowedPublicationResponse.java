package com.example.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedPublicationResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post")
    private List<PublicationResponse> publicationResponseList;

}
