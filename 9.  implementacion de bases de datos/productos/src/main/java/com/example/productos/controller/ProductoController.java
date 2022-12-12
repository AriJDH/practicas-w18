package com.example.productos.controller;

import com.example.productos.domain.Producto;
import com.example.productos.service.ProductoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoDbService productoDbService;

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return ResponseEntity.ok(productoDbService.save(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(productoDbService.findAll());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable String id){
        productoDbService.deleteById(id);
        return ResponseEntity.ok("El producto " + id + "fue eliminado.");
    }
}
