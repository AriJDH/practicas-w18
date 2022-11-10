package com.calcularedad.calcularEdad.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class CalcularEdad {
    @GetMapping("dates/{fecha}")

    public int calcular(@PathVariable  String fecha){
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaUser = LocalDate.parse(fecha, formato);
        return fechaActual.compareTo(fechaUser);

    }
}
