package com.ejercicios.calcularedad.controller;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class AgeController {

        @GetMapping("/{day}/{month}/{year}") //dd/MM/yyyy
        public String converterDate(@PathVariable Integer day,
                                    @PathVariable Integer month,
                                    @PathVariable Integer year) {

            LocalDate birth = LocalDate.of(year, month, day);
            LocalDate now = LocalDate.now();

            Period period = Period.between(birth, now);

            return String.format("%d", period.getYears());

        }
    }
