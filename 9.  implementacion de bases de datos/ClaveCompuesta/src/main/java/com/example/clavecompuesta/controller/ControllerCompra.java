package com.example.clavecompuesta.controller;

import com.example.clavecompuesta.DTO.CompraDTO;
import com.example.clavecompuesta.service.IServiceCompra;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerCompra {
    private final IServiceCompra iServiceCompra;

    public ControllerCompra(IServiceCompra iServiceCompra){
        this.iServiceCompra = iServiceCompra;
    }

    @PostMapping("/Compra")
    public ResponseEntity<CompraDTO> nuevaCompra(@RequestBody CompraDTO compraDTO){
        return new ResponseEntity<>(iServiceCompra.nuevaCompra(compraDTO), HttpStatus.CREATED);
    }
    @PostMapping("/Compras")
    public ResponseEntity<List<CompraDTO>> nuevaCompra(@RequestBody List<CompraDTO> comprasDTO){
        return new ResponseEntity<>(iServiceCompra.nuevaCompra(comprasDTO), HttpStatus.CREATED);
    }
}
