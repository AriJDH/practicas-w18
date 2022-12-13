package com.example.empresa_elasticsearch.controller;

import com.example.empresa_elasticsearch.dto.CreacionEmpleadoDTO;
import com.example.empresa_elasticsearch.dto.CreacionProductoDTO;
import com.example.empresa_elasticsearch.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    private IProductoService iProductoService;

    public ProductoController(IProductoService iProductoService) {
        this.iProductoService = iProductoService;
    }

    @PostMapping("/crearProducto")
    public ResponseEntity<?> crearEmpleado(@RequestBody CreacionProductoDTO creacionProductoDTO) {
        return ResponseEntity.ok(this.iProductoService.crearProducto(creacionProductoDTO));
    }
}
