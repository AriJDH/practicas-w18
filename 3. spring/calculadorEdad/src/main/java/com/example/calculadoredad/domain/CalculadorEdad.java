package com.example.calculadoredad.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class CalculadorEdad {
    public static int getYears(LocalDate bornDate){
        return Period.between(bornDate, LocalDate.now()).getYears();
    }
}
