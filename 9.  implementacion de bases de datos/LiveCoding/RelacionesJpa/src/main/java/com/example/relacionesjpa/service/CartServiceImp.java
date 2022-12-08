package com.example.relacionesjpa.service;

import com.example.relacionesjpa.dto.CartDto;
import com.example.relacionesjpa.dto.RespCartDto;
import com.example.relacionesjpa.entity.OneToMany.Cart;
import com.example.relacionesjpa.repository.CartRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.relacionesjpa.util.Mapeador.*;

@Service
public class CartServiceImp implements ICartService{

    CartRepository cartRepository;

    public CartServiceImp(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartDto> buscarTodos() {
        /*
        List<Cart> carritosEnt = cartRepository.findAll();

        List<CartDto> carritosDto = carritosEnt.stream()
                .map(c-> entityToDto(c))
                .collect(Collectors.toList());

        return carritosDto;
        */
        ModelMapper mapper = new ModelMapper();

        List<Cart> carritosEnt = cartRepository.findAll();

        List<CartDto> carritosDto = new ArrayList<>();

        carritosEnt.stream()
                .forEach(c-> carritosDto.add(mapper.map(c,CartDto.class)));

        return carritosDto;
    }

    @Override
    public RespCartDto guardarCart(CartDto cartDto) {
        ModelMapper modelMapper = new ModelMapper();

        Cart cart = modelMapper.map(cartDto,Cart.class);
        cart.getItems().forEach(i-> i.setCart(cart));

        Cart persistCart = cartRepository.save(cart);

        RespCartDto resp = new RespCartDto();
        resp.setCart(modelMapper.map(persistCart,CartDto.class));
        resp.setMensaje("Ahora si espero....");
        return resp;
    }

    @Override
    public RespCartDto borrarCart(Long id) {
        cartRepository.deleteById(id);
        RespCartDto resp = new  RespCartDto();
        resp.setMensaje("borrado exitoso");
        return resp;
    }

    @Override
    public CartDto obtenerPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional <Cart> cart =cartRepository.findById(id);

        CartDto respuesta = mapper.map(cart,CartDto.class);

        return respuesta;
    }
}
