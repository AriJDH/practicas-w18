package com.example.prueba.controller;


import com.example.prueba.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
    @GetMapping("/empleado/{name}/{lastName}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastName){
        Employee employee = new  Employee(name, lastName);
        return employee;
        
    }

}
