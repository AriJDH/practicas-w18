package com.example.productos.service;

import com.example.productos.domain.Producto;

import java.util.List;

public interface IProductoService {
    Producto save(Producto producto);
    List<Producto> findAll();
    Producto update(String id, Producto producto);
    Producto findById(String id);
    void deleteById(String id);
}
