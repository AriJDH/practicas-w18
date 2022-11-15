package com.example.numerosromanos.controller;

import com.example.numerosromanos.service.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConverterController {
    private final ConverterService modelo;
    public ConverterController() {
        this.modelo = new ConverterService();
    }
    @GetMapping("/convertir/{romano}")
    public String enteroARomano(@PathVariable Integer romano) {
        return modelo.romanize(romano);
    }
    
}
