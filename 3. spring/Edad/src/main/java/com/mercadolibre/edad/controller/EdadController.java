package com.mercadolibre.edad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/edad")
public class EdadController {

    @GetMapping("/completa/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdadCompleta(@PathVariable int dia,
                                                       @PathVariable int mes,
                                                       @PathVariable int anio){
        // TODO fechas en el futuro
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaStr = String.format("%02d/%02d/%04d", dia, mes, anio); // 01/01/2000
        LocalDate fechaNac = LocalDate.parse(fechaStr, dtf);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return ResponseEntity.ok(String.format("%s años, %s meses y %s días",
                periodo.getYears(), periodo.getMonths(), periodo.getDays()));
    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(@PathVariable int dia,
                                               @PathVariable int mes,
                                               @PathVariable int anio){
        // TODO fechas en el futuro
        LocalDate fechaNac = LocalDate.of(anio, mes, dia);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return ResponseEntity.ok(String.valueOf(periodo.getYears()));
    }
}
