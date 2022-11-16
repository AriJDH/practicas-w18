package com.example.apiedad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Period;

@SpringBootApplication
public class ApiEdadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEdadApplication.class, args);
    }
        Period p = Period.between(LocalDate.of(1983,12,20),LocalDate.now());
        Long s = p.toTotalMonths();
}
