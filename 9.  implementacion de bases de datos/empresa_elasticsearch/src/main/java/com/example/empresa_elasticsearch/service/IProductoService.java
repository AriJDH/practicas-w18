package com.example.empresa_elasticsearch.service;

import com.example.empresa_elasticsearch.dto.CreacionProductoDTO;

public interface IProductoService {

    String crearProducto(CreacionProductoDTO creacionProductoDTO);
}
