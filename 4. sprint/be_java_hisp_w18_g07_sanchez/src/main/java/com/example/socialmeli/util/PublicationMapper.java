package com.example.socialmeli.util;

import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.entity.PublicationEntity;

public class PublicationMapper {

    public static PublicationEntity publicationRequest2PublicationEntity (PublicationRequest request) {

        PublicationEntity entity = new PublicationEntity();
        entity.setDate(request.getDate());
        entity.setUserId(request.getUserId());
        entity.setProductId(request.getProductRequest().getId());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());

        return entity;
    }

}
