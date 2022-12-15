package com.example.relacionesjpa.controller;

import com.example.relacionesjpa.dto.CartDto;
import com.example.relacionesjpa.service.CartServiceImp;
import com.example.relacionesjpa.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    ICartService cartService;

    public CartController(CartServiceImp cartService){
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getCarts(){
        return new ResponseEntity<>(cartService.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardarCart(@RequestBody CartDto cart){
        return new ResponseEntity<>(cartService.guardarCart(cart),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarCarrito(@PathVariable Long id){
        return new ResponseEntity<>(cartService.borrarCart(id),HttpStatus.OK);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id){
        return new ResponseEntity<>(cartService.obtenerPorId(id),HttpStatus.OK);
    }
}
