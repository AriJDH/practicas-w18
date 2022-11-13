package com.bootcamp.edades.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
@Service
public class EdadService {

    public String anosDeEdad(Integer dia, Integer mes, Integer ano){
        LocalDate fecha=LocalDate.of(ano,mes,dia);
        Period period= Period.between(fecha,LocalDate.now());
       return "Su edad es: "+period.getYears();

    }
}
