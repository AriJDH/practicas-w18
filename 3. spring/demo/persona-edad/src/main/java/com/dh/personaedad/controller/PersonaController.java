package com.dh.personaedad.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class PersonaController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer addEdad(@PathVariable String dia,
                           @PathVariable String mes,
                           @PathVariable String ano){

        LocalDate birthDate = LocalDate.of(
                Integer.parseInt(ano),
                Integer.parseInt(mes),
                Integer.parseInt(dia));

        return Period.between(birthDate, LocalDate.now()).getYears();
    }

}
