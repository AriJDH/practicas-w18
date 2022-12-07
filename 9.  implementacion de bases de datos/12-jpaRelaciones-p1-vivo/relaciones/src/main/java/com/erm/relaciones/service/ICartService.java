package com.erm.relaciones.service;

import com.erm.relaciones.dto.CartDto;
import com.erm.relaciones.dto.ResponseCartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> buscarTodos();
    ResponseCartDto guardarCart(CartDto cartDto);
}
