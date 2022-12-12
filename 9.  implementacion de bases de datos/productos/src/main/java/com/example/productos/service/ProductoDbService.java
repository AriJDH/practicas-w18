package com.example.productos.service;

import com.example.productos.domain.Producto;

import java.util.List;

public interface ProductoDbService {
    Producto save(Producto producto);
    List<Producto> findAll();
    void deleteById(String id);
}
