package com.example.socialmeli.util;

import com.example.socialmeli.dto.request.PostProductPromRequest;
import com.example.socialmeli.dto.request.PublicationRequest;
import com.example.socialmeli.entity.PostProductPromEntity;
import com.example.socialmeli.entity.PublicationEntity;

public class PublicationPromoMapper {

    public static PostProductPromEntity publicationPromEntity (PostProductPromRequest request) {

        PostProductPromEntity entity = new PostProductPromEntity();
        entity.setDate(request.getDate());
        entity.setUserId(request.getUserId());
        entity.setProductId(request.getProductRequest().getId());
        entity.setCategory(request.getCategory());
        entity.setPrice(request.getPrice());
        entity.setHasPromo(request.isHasPromo());
        entity.setDiscount(request.getDiscount());

        return entity;
    }

}
