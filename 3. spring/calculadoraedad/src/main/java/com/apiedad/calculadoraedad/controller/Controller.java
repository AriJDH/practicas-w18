package com.apiedad.calculadoraedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {
    @GetMapping("/{dia}/{mes}/{ano}")
    public String calcularEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int ano){
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        Period intervalo = Period.between(fechaNacimiento, LocalDate.now());
        return String.format("%d",intervalo.getYears());
    }
}
