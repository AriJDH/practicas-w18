package com.modulospring.calculaEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@RestController
public class Controller {
    @GetMapping("/{day}/{month}/{year}")
    public String devolverFecha(@PathVariable Integer day,
                                @PathVariable Integer month,
                                @PathVariable Integer year){

        LocalDate fNacimiento = LocalDate.of(year,month,day);
        LocalDate fActual = LocalDate.now();
        Long edad = ChronoUnit.YEARS.between(fNacimiento, fActual);

        return edad.toString();
    }
}
