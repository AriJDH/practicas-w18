package com.example.edad_persona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@RestController
public class EdadRestController {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
        return Long.toString(edad);

    }
}
