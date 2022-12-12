package com.example.clavecompuesta.service;


import com.example.clavecompuesta.DTO.CompraDTO;

import java.util.List;

public interface IServiceCompra {
    CompraDTO nuevaCompra(CompraDTO compraDTO);
    List<CompraDTO> nuevaCompra(List<CompraDTO> compraDTO);
}
