package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Date;

@RestController
public class EdadPersonaController {
    @GetMapping("/persona/Edad/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable Integer dia,
                          @PathVariable Integer mes,
                          @PathVariable Integer anio)
    {
        LocalDate date = LocalDate.of(anio,mes,dia);
        Integer edad = Period.between(date,LocalDate.now()).getYears();
        return "La edad de la persona es " + edad.toString();
    };
}
