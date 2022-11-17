package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

import java.util.List;

public class RecentPostsDtoRes {
    @JsonProperty("user_id")
    private Integer userId;
    List<PostDtoRes> posts;
}
