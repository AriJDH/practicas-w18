package com.spring.linktracker.utils;

import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;

public class LinkMapper {

    public static LinkDtoRes    entity2Response(Link entity) {

        LinkDtoRes response = new LinkDtoRes();
        response.setId(entity.getId());
        response.setUrl(entity.getUrl());
        response.setIsValid(entity.getIsValid());

        return response;
    }
}
