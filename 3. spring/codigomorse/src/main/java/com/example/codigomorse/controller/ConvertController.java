package com.example.codigomorse.controller;

import com.example.codigomorse.service.ConvertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    private ConvertService modelo;

    public ConvertController() {
        this.modelo = new ConvertService();
    }

    @GetMapping("/morseconver/{codigo}")
    public String convertConversor(@PathVariable String codigo){
        return modelo.decodificar(codigo);
    }
}
