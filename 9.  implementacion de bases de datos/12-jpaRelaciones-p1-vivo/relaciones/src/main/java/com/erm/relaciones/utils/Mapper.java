package com.erm.relaciones.utils;

import com.erm.relaciones.dto.CartDto;
import com.erm.relaciones.entity.manyone.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {
    public static CartDto cartEntityToDto(Cart cart) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(cart, CartDto.class);
    }

    public static Cart cartDtoToEntity(CartDto cartDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(cartDto, Cart.class);
    }
}
