package com.mercadolibre.socialmeli2.utils;

import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.response.PostDtoRes;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;

public class DTOConverter {
    public static ProductDto entityToDto(Product entity){
        return new ProductDto(entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getBrand(),
                entity.getColor(),
                entity.getNotes());
    }
    public static PostDtoRes entityToDto(Post entity, Integer userId){
        return new PostDtoRes(userId,
                entity.getId(),
                entity.getDate(),
                entityToDto(entity.getProduct()),
                entity.getCategory(),
                entity.getPrice());
    }
}
