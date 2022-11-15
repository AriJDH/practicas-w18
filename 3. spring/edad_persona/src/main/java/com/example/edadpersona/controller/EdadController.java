package com.example.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadController {

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        LocalDate hoy = LocalDate.now();
        LocalDate cumple = LocalDate.of(anio, mes, dia);

        Long edad = ChronoUnit.YEARS.between(cumple, hoy);

        if (edad < 0) {
            return "Todavía no nació.";
        }

        return edad.toString();
    }
}
