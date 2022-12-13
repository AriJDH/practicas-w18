package com.example.relacionesjpa.util;

import com.example.relacionesjpa.dto.CartDto;
import com.example.relacionesjpa.dto.RespCartDto;
import com.example.relacionesjpa.entity.OneToMany.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapeador {

    public static CartDto entityToDto (Cart cart){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(cart, CartDto.class);
    }

    public static Cart dtoToEntity (CartDto cart){

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(cart, Cart.class);
    }


}
