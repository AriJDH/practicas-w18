package com.spring.fechas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia,
                       @PathVariable int mes,
                       @PathVariable int anio) {
        //obtains an instance of LocalDate from a year, month and date
        LocalDate dob = LocalDate.of(anio, mes, dia);
        //obtains the current date from the system clock
        LocalDate curDate = LocalDate.now();
        //calculates the difference betwween two dates
        Period period = Period.between(dob, curDate);
        //prints the differnce in years, months, and days
        return period.getYears();
    }
}
