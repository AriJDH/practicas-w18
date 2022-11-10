package com.example.demo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadController {
    @GetMapping("/edad/{dia}/{mes}/{año}")
    public String edad(@PathVariable String dia, @PathVariable String mes, @PathVariable String año) {

        String fdn = dia + "/" + mes + "/" + año;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fdn, fmt);
        LocalDate hoy = LocalDate.now();

        Period period = Period.between(fechaNac, hoy);
        int edad = period.getYears();
        return String.valueOf(edad);
    }
}
