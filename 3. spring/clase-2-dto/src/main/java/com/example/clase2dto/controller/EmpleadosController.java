package com.example.clase2dto.controller;

import com.example.clase2dto.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController {
    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname) {
        Employee employee = new Employee(name, lastname);

        return employee;
    }

//    @GetMapping public Employee findEmployee()
}
