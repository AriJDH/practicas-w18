package com.erm.relaciones.service;

import com.erm.relaciones.dto.CartDto;
import com.erm.relaciones.dto.ResponseCartDto;
import com.erm.relaciones.entity.manyone.Cart;
import com.erm.relaciones.repository.ICartRepository;
import com.erm.relaciones.utils.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService{

    private final ICartRepository cartRepository;
    private final ObjectMapper objectMapper;

    public CartServiceImpl(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<CartDto> buscarTodos() {
        List<Cart> cartList = cartRepository.findAll();
        return cartList.stream()
                .map(Mapper::cartEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCartDto guardarCart(CartDto cartDto) {
        ModelMapper modelMapper = new ModelMapper();
        Cart cartToSave = modelMapper.map(cartDto, Cart.class);
        cartToSave.getItems().forEach(item -> item.setCart(cartToSave));

        Cart cart = cartRepository.save(cartToSave);

        ResponseCartDto responseCartDto = new ResponseCartDto();
        responseCartDto.setCartDto(modelMapper.map(cart, CartDto.class));
        responseCartDto.setMessage("Todo ok, let's goooo");
        return responseCartDto;
    }
}
