package com.example.clase2dto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;


@RestController
public class EdadController {
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public int calculaEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate actual = LocalDate.now();
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);

        return Period.between(nacimiento, actual).getYears();
    }

}
