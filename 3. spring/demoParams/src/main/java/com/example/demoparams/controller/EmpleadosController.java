package com.example.demoparams.controller;
import com.example.demoparams.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadosController {

    @GetMapping("/employee/{name}/{lastName}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastName){
        return new Employee(name, lastName);
    }

    @GetMapping("/employee/")
    public Employee findEmployee(@RequestParam String name, @RequestParam String lastName){
        return new Employee(name, lastName);
    }

    @PostMapping("/crear")
    public Employee createEmployee(@RequestBody Employee emp){
        return emp;
    }

    @PostMapping("/crearVarios")
    public List<Employee> createEmployee(@RequestBody List<Employee> emps){
        return emps;
    }
}
