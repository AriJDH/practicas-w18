package com.example.demoparams.controller;

import com.example.demoparams.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

    @GetMapping(path = "/{name}/{lastname}/")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        System.out.println("hola");
        return new Employee(name, lastname);

    }
}
