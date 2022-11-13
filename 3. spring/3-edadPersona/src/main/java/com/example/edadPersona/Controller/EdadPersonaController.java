package com.example.edadPersona.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}/")
    public String edadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        LocalDate fechaActual = LocalDate.now(); //Toma la fecha actual
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia); //agrega la fecha que se paso por parametro

        Period edad = Period.between(fechaNacimiento, fechaActual); // genera el periodo entre ambas fechas

        return String.valueOf(edad.getYears()); //devuelvo unicamente la cantidad de años entre ambos.
    }
}
