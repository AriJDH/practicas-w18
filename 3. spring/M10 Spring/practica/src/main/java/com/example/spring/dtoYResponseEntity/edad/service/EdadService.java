package com.example.spring.dtoYResponseEntity.edad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class EdadService {


    public String calcularEdad(int day, int month, int year){
        Calendar fechaActual = new GregorianCalendar();
        int anioActual = fechaActual.get(Calendar.YEAR);
        int mesActual = fechaActual.get(Calendar.MONTH);
        int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);

        if (year > Calendar.YEAR){
            return "Todavía no llegamos a ese año!";
        }

        Calendar fechaNac = new GregorianCalendar(year, month, day);

        int edad = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);



        //Mostramos por pantalla edad
        return "Edad: " + edad;
    }



    public String calcularEdad2(int day, int month, int year){
        LocalDate dateInput = LocalDate.of(year, month, day);
        LocalDate dateNow = LocalDate.now();

        if (year > Calendar.YEAR){
            return "Todavía no llegamos a ese año!";
        }

        Long edad = ChronoUnit.YEARS.between(dateInput, dateNow);
        return edad.toString();
    }
}
