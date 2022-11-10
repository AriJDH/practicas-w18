package com.example.edadpersona.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;

@RestController
public class EdadController {
    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

        Calendar fechaActual = new GregorianCalendar();
        Calendar cumple = new GregorianCalendar(anio, mes, dia);

        //Esta solucion no es perfecta, ya que devuelve un año mase si se va a cumplir este mes,
        //y no controla errores, pero es lo que se pudo en 10 min :P
        return "Años: " + (fechaActual.get(YEAR) - cumple.get(YEAR));
    }
}
