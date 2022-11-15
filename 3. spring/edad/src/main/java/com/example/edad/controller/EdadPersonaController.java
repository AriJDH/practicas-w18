package com.example.edad.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {
    @GetMapping(path = "/edadPersona/{dia}/{mes}/{anio}")
    public String edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        System.out.println("Voy a calcular la edad");
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        Period edad = Period.between(fechaNacimiento, fechaActual);
        return String.valueOf(edad.getYears());
    }
}

