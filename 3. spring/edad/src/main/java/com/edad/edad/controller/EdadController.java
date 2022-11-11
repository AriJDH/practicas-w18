package com.edad.edad.controller;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.time.temporal.ChronoUnit.YEARS;

@RestController
public class EdadController {

    @GetMapping("/{fecha}")
    public String calcularEdad(@PathVariable String fecha ){
        String[] f = fecha.split("-");
        LocalDate fechita = LocalDate.of(Integer.valueOf(f[2]),Integer.valueOf(f[1]),Integer.valueOf(f[0]));
        LocalDate fechaActual = LocalDate.now();
        long dif = YEARS.between(fechita,fechaActual);

        if(dif<0) {
            return ("La fecha no puede ser mayor al dìa de hoy");
        }

        return ("La edad es: "+dif);
    }
}
