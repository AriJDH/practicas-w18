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
public class UserFollowedListResponse {

    @JsonProperty("user_id")
    private Integer id;

    @JsonProperty("user_name")
    private String name;

    @JsonProperty("followed")
    List<UserBasicResponse> userBasicResponseList;

}
