package com.spring.clase2.controller;

import com.spring.clase2.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController {

    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        Employee employee = new Employee(name, lastname);
        return employee;
    }

    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam String name, @RequestParam(required = false) String lastname){
        Employee employee = new Employee(name, lastname);

        return employee;
    }
    //recibe un body en formato JSON
    @PostMapping("/crear")
    public Employee createEmployee(@RequestBody Employee employee){
        return employee;
    }
}
