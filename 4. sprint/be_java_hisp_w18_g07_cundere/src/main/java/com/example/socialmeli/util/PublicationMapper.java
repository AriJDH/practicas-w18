package com.example.socialmeli.util;

import com.example.socialmeli.dto.request.PublicationPromoRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.dto.response.PublicationResponse;
import com.example.socialmeli.entity.ProductEntity;
import com.example.socialmeli.entity.PublicationEntity;
import com.example.socialmeli.entity.PublicationPromoEntity;

import java.util.ArrayList;
import java.util.List;

public class PublicationMapper {

    public static PublicationEntity publicationRequest2PublicationEntity(PublicationRequest request) {

        PublicationEntity entity = new PublicationEntity();
        entity.setDate(request.getDate());
        entity.setUserId(request.getUserId());
        entity.setProductId(request.getProductRequest().getId());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());

        return entity;
    }

    public static PublicationPromoEntity publicationPromoRequest2PublicationPromoEntity(PublicationPromoRequest request) {

        PublicationPromoEntity entity = new PublicationPromoEntity();
        entity.setDate(request.getDate());
        entity.setUserId(request.getUserId());
        entity.setProductId(request.getProductRequest().getId());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());
        entity.setHasPromo(request.getHasPromo());
        entity.setDiscount(request.getDiscount());

        return entity;
    }

    public static PublicationResponse anyTypeOfPublicationEntity2PublicationResponse(PublicationEntity entity,
                                                                                     ProductEntity productEntity, Double price) {

        PublicationResponse response = new PublicationResponse();
        response.setId(entity.getId());
        response.setDate(entity.getDate());
        response.setUserId(entity.getUserId());
        response.setProductResponse(ProductMapper.productEntity2ProductResponse(productEntity));
        response.setCategory(entity.getCategory());
        response.setPrice(price);

        return response;

    }

}
