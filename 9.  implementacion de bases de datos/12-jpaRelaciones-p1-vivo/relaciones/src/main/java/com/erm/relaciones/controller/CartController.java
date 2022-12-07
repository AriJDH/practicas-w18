package com.erm.relaciones.controller;

import com.erm.relaciones.dto.CartDto;
import com.erm.relaciones.service.CartServiceImpl;
import com.erm.relaciones.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    ICartService cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getCarts() {
        return new ResponseEntity<>(cartService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCart(@RequestBody CartDto cartDto) {
        return new ResponseEntity<>(cartService.guardarCart(cartDto), HttpStatus.OK);
    }
}
