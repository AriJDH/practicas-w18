package com.example.productos.controller;

import com.example.productos.dto.request.ProductoRequest;
import com.example.productos.dto.response.ProductoResponse;
import com.example.productos.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService productoService;


    @PostMapping("/crear")
    public ResponseEntity<ProductoResponse> createProducto(@RequestBody ProductoRequest request) {

        return new ResponseEntity<>(productoService.createProducto(request), HttpStatus.OK);
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<ProductoResponse> updateProducto(@PathVariable String id, @RequestBody ProductoRequest request) {

        return new ResponseEntity<>(productoService.updateProducto(id, request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllProducto(){

        return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

}
