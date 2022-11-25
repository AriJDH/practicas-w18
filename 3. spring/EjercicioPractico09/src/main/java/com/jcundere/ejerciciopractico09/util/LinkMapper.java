package com.jcundere.ejerciciopractico09.util;

import com.jcundere.ejerciciopractico09.dto.response.LinkMetricsResponse;
import com.jcundere.ejerciciopractico09.dto.response.LinkResponse;
import com.jcundere.ejerciciopractico09.entity.LinkEntity;

public class LinkMapper {

    public static LinkResponse entity2Response(LinkEntity entity) {

        LinkResponse response = new LinkResponse();
        response.setId(entity.getId());
        response.setUrl(entity.getUrl());
        response.setIsValid(entity.getIsValid());

        return response;
    }

    public static LinkMetricsResponse entity2MetricsResponse(LinkEntity entity) {

        LinkMetricsResponse response = new LinkMetricsResponse();
        response.setId(entity.getId());
        response.setVisited(entity.getVisited());

        return response;
    }

}
