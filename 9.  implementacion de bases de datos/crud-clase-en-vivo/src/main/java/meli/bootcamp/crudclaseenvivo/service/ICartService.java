package meli.bootcamp.crudclaseenvivo.service;

import meli.bootcamp.crudclaseenvivo.dto.req.CartDto;
import meli.bootcamp.crudclaseenvivo.dto.res.ResponseCartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> findAllCarts();
    ResponseCartDto saveCart(CartDto cartDto);
}
