package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.CartDto;
import com.example.relacionesjpa.dto.RespCartDto;
import com.example.relacionesjpa.entity.OneToMany.Cart;

import java.util.List;

public interface ICartService {

    List<CartDto> buscarTodos();
    RespCartDto guardarCart(CartDto cart);
    RespCartDto borrarCart(Long id);
    CartDto obtenerPorId(Long id);
}
