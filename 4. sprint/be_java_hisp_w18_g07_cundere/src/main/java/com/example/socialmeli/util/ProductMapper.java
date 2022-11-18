package com.example.socialmeli.util;

import com.example.socialmeli.dto.response.ProductResponse;
import com.example.socialmeli.entity.ProductEntity;

public class ProductMapper {

    public static ProductResponse productEntity2ProductResponse (ProductEntity entity) {

        ProductResponse response = new ProductResponse();
        response.setName(entity.getName());
        response.setType(entity.getType());
        response.setBrand(entity.getBrand());
        response.setColor(entity.getColor());
        response.setNotes(entity.getNotes());

        return response;

    }

}
