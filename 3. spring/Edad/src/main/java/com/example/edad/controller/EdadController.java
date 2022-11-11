package com.example.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadController {

    @GetMapping("/{day}/{month}/{year}")
    public String edad(@PathVariable int day, @PathVariable int month, @PathVariable int year){

        LocalDate input = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

       long edad = ChronoUnit.YEARS.between(input, now);

       return "Tu edad es: " + edad;

    }
}
