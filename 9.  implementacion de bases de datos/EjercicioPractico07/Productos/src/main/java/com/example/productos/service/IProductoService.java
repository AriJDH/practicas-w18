package com.example.productos.service;

import com.example.productos.dto.request.ProductoRequest;
import com.example.productos.dto.response.ProductoResponse;
import com.example.productos.entity.Producto;

import java.util.List;

public interface IProductoService {

    ProductoResponse createProducto(ProductoRequest request);

    ProductoResponse updateProducto(String id, ProductoRequest request);

    List<Producto> getAll();

}
