package com.example.DateCalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class DateController {

    @GetMapping("/{day}/{month}/{year}")
    public String ageCalculator(@PathVariable String day,@PathVariable String month,@PathVariable String year){
        String fdn = day + "/" + month + "/" + year;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fdn, fmt);
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(fechaNac, hoy);
        return String.valueOf(period.getYears());
    }
}
