package com.example.demoparams.controller;
import com.example.demoparams.DTO.EmployeeDTOReq;
import com.example.demoparams.DTO.EmployeeDTORes;
import com.example.demoparams.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EmployeeDTORes> createEmployee(@RequestBody EmployeeDTOReq emp){
        EmployeeDTORes res = new EmployeeDTORes(emp.getName(), emp.getLastName(), "Creado exitosamente");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/crearVarios")
    public List<Employee> createEmployee(@RequestBody List<Employee> emps){
        return emps;
    }
}
