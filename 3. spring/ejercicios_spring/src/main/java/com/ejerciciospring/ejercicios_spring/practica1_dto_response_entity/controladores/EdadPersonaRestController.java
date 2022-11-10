package com.ejerciciospring.ejercicios_spring.practica1_dto_response_entity.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadPersonaRestController {

    @GetMapping("/calcularEdadPersona/{dia}/{mes}/{anio}")
    public String calcularEdadPersona(@PathVariable Integer dia,
                                      @PathVariable Integer mes,
                                      @PathVariable Integer anio) {

        LocalDate fechaSistema = LocalDate.now();

        int diaActual = fechaSistema.getDayOfMonth();

        int mesActual = fechaSistema.getMonthValue();

        int anioActual = fechaSistema.getYear();
        int edad = anioActual - anio;

        if (mes > mesActual || dia > diaActual) {
            edad -= 1;
        }

        return String.valueOf(edad);
    }

    @GetMapping("/calcularEdadPersona2/{dia}/{mes}/{anio}")
    public String calcularEdadPersona2(@PathVariable String dia,
                                       @PathVariable String mes,
                                       @PathVariable String anio) {

        String fdn = dia + "/" + mes + "/" + anio;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fdn, fmt);
        LocalDate hoy = LocalDate.now();

        Period period = Period.between(fechaNac, hoy);

        return String.valueOf(period.getYears());
    }
}
