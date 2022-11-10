package com.example.codigomorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    private Model modelo;

    public void ConvertController() {
        this.modelo = new Model();
    }

    @GetMapping("/morseconver/{codigo}")
    public String convertConversor(@PathVariable String codigo){
        return modelo.decodificar(codigo);
    }

}
