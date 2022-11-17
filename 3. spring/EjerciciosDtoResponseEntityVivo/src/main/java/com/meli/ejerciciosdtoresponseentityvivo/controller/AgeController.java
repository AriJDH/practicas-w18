package com.meli.ejerciciosdtoresponseentityvivo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class AgeController {
    @GetMapping("/{day}/{month}/{year}")
    public Long getAge(@PathVariable("day") Integer day, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        LocalDate localdate = LocalDate.of(year, month, day);
        LocalDate nowdate = LocalDate.now();
        return ChronoUnit.YEARS.between(localdate,nowdate);
    }
}
