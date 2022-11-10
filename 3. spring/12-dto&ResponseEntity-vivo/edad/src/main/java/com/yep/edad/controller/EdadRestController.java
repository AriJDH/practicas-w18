package com.yep.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class EdadRestController {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable int dia,
                       @PathVariable int mes,
                       @PathVariable int anio) {
        Calendar calendario = Calendar.getInstance();

        int diaActual = calendario.get(Calendar.DATE);
        int mesActual = calendario.get(Calendar.MONTH) + 1;
        int anioActual = calendario.get(Calendar.YEAR);

        int anios;

        if(anioActual <= anio) {
            return "0";
        } else {
            anios = anioActual - anio;
        }

        if(mesActual < mes) {
            anios--;
        } else if (diaActual < dia && mesActual == mes) {
            anios--;
        }

        return anios + "";
    }
}
