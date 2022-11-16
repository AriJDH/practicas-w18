package com.example.primerProyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("hello/{numero}")
    public String hello(@PathVariable Integer numero) {

        NumerosRomanos numerosRomanos = new NumerosRomanos();
        String romanos = numerosRomanos.generarNumeroRomano(numero);

        return romanos;
    }
}
