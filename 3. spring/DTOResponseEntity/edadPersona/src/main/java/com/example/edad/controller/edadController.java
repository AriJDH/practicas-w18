package com.example.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@RestController
public class edadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fechaDeHoy = LocalDate.now();

        Long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaDeHoy);

        return String.valueOf(edad);
    }
}
