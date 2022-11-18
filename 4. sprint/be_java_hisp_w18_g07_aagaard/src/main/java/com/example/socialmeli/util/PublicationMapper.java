package com.example.socialmeli.util;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.entity.PublicationPromoEntity;

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

    public static PublicationPromoEntity publicationPromoRequest2PublicationPromoEntity (PublicationPromoRequest request) {
        PublicationPromoEntity entity = new PublicationPromoEntity();
        entity.setDate(request.getDate());
        entity.setUserId(request.getUserId());
        entity.setProductId(request.getProductRequest().getId());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());
        entity.setHasPromo(entity.getHasPromo());
        entity.setDiscount(entity.getDiscount());
        return entity;
    }

}
