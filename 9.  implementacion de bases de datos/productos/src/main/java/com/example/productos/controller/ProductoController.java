package com.example.productos.controller;

import com.example.productos.domain.Producto;
import com.example.productos.service.IProductoService;
import com.example.productos.service.ProductoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.save(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        productoService.deleteById(id);
        return ResponseEntity.ok("El producto " + id + "fue eliminado.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable String id){
        return ResponseEntity.ok(productoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable String id,@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.update(id,producto));
    }


}
