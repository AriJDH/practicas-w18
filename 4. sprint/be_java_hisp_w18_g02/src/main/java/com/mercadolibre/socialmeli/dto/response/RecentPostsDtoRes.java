package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecentPostsDtoRes {
    @JsonProperty("user_id")
    private Integer userId;
    List<PostDtoRes> posts;
}
