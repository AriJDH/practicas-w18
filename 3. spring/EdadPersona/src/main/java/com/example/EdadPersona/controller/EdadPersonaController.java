package com.example.EdadPersona.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;

@RestController
public class EdadPersonaController {

    @GetMapping("edad/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

        //LocalDate fechaNacimiento = new LocalDate(anio,mes,dia);
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DATE,dia);
        c1.set(Calendar.MONTH,mes);
        c1.set(Calendar.YEAR,anio);

        Calendar c2 = Calendar.getInstance();


        Integer diferencia = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);








        return String.valueOf(diferencia);
    }



}
