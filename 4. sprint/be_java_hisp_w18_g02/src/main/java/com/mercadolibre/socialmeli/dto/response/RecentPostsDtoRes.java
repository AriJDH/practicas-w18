package com.mercadolibre.socialmeli.dto.response;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

import java.util.List;

public class RecentPostsDtoRes {
    private Integer userId;
    List<PostDtoRes> posts;
}
