package com.example.spring.dtoYResponseEntity.edad.controller;

import com.example.spring.dtoYResponseEntity.edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    EdadService edadService = new EdadService();

    @GetMapping("/calcularedad/{day}/{month}/{year}")
    public String calculaEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        String edad = edadService.calcularEdad(day, month, year);
        return edad;
    }

    @GetMapping("/calcularedad2/{day}/{month}/{year}")
    public String calculaEdad2(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        String edad = edadService.calcularEdad2(day, month, year);
        return edad;
    }


}
