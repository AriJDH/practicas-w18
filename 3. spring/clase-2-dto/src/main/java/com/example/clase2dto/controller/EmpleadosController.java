package com.example.clase2dto.controller;

import com.example.clase2dto.DTO.EmployeeDTO;
import com.example.clase2dto.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadosController {
    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname) {
        Employee employee = new Employee(name, lastname);

        return employee;
    }

    @PostMapping("/crear")
    public ResponseEntity<EmployeeDTO> createEmployeeDTO(@RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setMessage("Creado bien");
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }
}
