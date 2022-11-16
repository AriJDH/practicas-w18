package com.example.employeedemo.controller;

import com.example.employeedemo.dto.req.EmployeeDtoReq;
import com.example.employeedemo.dto.res.EmployeeDtoRes;
import com.example.employeedemo.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        return new Employee(name, lastname);
    }
    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam String name, @RequestParam String lastname){
        return new Employee(name, lastname);
    }

    @PostMapping("/crear")
    public ResponseEntity<EmployeeDtoRes> createEmployee(@RequestBody EmployeeDtoReq employee ){


        EmployeeDtoRes employeeDtoRes = new EmployeeDtoRes(employee.getName(), employee.getLastname(),"El empleado fue creado");

        return new ResponseEntity<>(employeeDtoRes, HttpStatus.CREATED);

    }
}
