package com.dto_resentity.edadpersona.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age")
public class EdadController {

    @GetMapping("/{day}/{month}/{year}")
    public String get(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate input = LocalDate.of(year, month, day);

        LocalDate dateNow = LocalDate.now();

        String age = Period.between(input, dateNow).toString();

        return age;
    }
}