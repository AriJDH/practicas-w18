package com.mercadolibre.socialmeli.dto.response;

import java.util.List;

public class PostsDtoRes extends RecentPostsDtoRes {
    public PostsDtoRes(Integer userId, List<PostDtoRes> posts) {
        super(userId, posts);
    }
}
