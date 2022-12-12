package com.example.elasticsearchspringprductos.controller;

import com.example.elasticsearchspringprductos.domain.Productos;
import com.example.elasticsearchspringprductos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductoService service;

    @PostMapping
    public ResponseEntity<Productos> create(@RequestBody Productos productos){
        return new ResponseEntity<>(service.save(productos), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Productos>> getAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Productos> update(@RequestBody Productos productos){
        return new ResponseEntity<>(service.update(productos),HttpStatus.OK);
    }
}
