package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostsGroupedByUserDtoRes {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;
    List<PostDtoRes> posts;
}
