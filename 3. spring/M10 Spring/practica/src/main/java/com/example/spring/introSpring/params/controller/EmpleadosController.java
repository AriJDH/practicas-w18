package com.example.spring.introSpring.params.controller;

import com.example.spring.introSpring.params.dto.request.EmployeeDTOreq;
import com.example.spring.introSpring.params.dto.response.EmployeeDTOresp;
import com.example.spring.introSpring.params.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadosController {

    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        Employee employee = new Employee(name, lastname);
        return employee;
    }



    @GetMapping("/employee/")
    public Employee findEmployee(@RequestParam String name, @RequestParam (required = false) String lasname){
        EmployeeDTOreq employeeDTOreq = new EmployeeDTOreq(name, lasname);
        Employee employee = new Employee(name, lasname);
        return employee;
    }

    @PostMapping("/crear")
    public ResponseEntity<EmployeeDTOresp> crear(@RequestBody EmployeeDTOreq employee){
        EmployeeDTOresp employeeDTOresp = new EmployeeDTOresp(employee.getName(), employee.getLastname(), "El empleado fue creado");
        return new ResponseEntity<>(employeeDTOresp, HttpStatus.CREATED);
    }

}
