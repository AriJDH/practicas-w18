package com.example.calculadoredad.controllers;

import com.example.calculadoredad.domain.CalculadorEdad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculadorEdad")
public class CalculadorEdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return Integer.toString(CalculadorEdad.getYears(LocalDate.of(anio,mes,dia)));
    }
}
