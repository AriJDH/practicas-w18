package com.example.clavecompuesta.controller;

import com.example.clavecompuesta.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping("/compra/new")
    public ResponseEntity<Void> createCompra() {

        compraService.createCompra();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
