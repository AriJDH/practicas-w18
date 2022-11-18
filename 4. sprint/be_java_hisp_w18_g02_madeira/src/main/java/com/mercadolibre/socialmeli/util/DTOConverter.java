package com.mercadolibre.socialmeli.util;

import com.mercadolibre.socialmeli.dto.ProductDto;
import com.mercadolibre.socialmeli.dto.PromoPostDto;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.entity.Post;
import com.mercadolibre.socialmeli.entity.Product;

public class DTOConverter {
    public static Product dtoToEntity(ProductDto dto){
        return new Product(dto.getId(),
                dto.getName(),
                dto.getType(),
                dto.getBrand(),
                dto.getColor(),
                dto.getNotes());
    }
    public static Post dtoToEntity(PostDtoReq dto, Integer id){
        return new Post(id,
                dto.getDate(),
                dto.getCategory(),
                dto.getPrice(),
                dtoToEntity(dto.getProduct()),
                false,
                0.0);
    }
    public static Post dtoToEntity(PromoPostDto dto, Integer id){
        return new Post(id,
                dto.getDate(),
                dto.getCategory(),
                dto.getPrice(),
                dtoToEntity(dto.getProduct()),
                dto.getHasPromo(),
                dto.getDiscount());
    }

    public static ProductDto entityToDto(Product entity){
        return new ProductDto(entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getBrand(),
                entity.getColor(),
                entity.getNotes());
    }
    public static PromoPostDto entityToDto(Post entity, Integer userId){
        return new PromoPostDto(userId,
                entity.getId(),
                entity.getDate(),
                entityToDto(entity.getProduct()),
                entity.getCategory(),
                entity.getPrice(),
                entity.getHasPromo(),
                entity.getDiscount());
    }

}
