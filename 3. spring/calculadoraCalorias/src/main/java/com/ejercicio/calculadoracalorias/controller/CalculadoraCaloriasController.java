package com.ejercicio.calculadoracalorias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraCaloriasController {


    @GetMapping("")
    public ResponseEntity<CalculadoraCalorasDTOres> (){

    }
}
