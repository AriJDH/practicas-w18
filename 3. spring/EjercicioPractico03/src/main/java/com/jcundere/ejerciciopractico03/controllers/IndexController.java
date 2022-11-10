package com.jcundere.ejerciciopractico03.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class IndexController {

    @GetMapping("/{day}/{month}/{year}")
    public String devolverFecha(@PathVariable Integer day,
                                @PathVariable Integer month,
                                @PathVariable Integer year){

        LocalDate dateInput = LocalDate.of(year,month,day);
        LocalDate dateNow = LocalDate.now();

        Long edad = ChronoUnit.YEARS.between(dateInput, dateNow);

        if (edad <= 0 ) {
            return "No se permiten edades iguales o menores a 0";
        } else {
            return edad.toString();
        }
        
    }

}
