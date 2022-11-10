package com.example.demo.Controller;

import com.example.demo.DTO.Request.EmployeeDTOReq;
import com.example.demo.DTO.Response.EmployeeDTORes;
import com.example.demo.Entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController {

    @GetMapping("/employee/")
    public Employee getEmployee(@RequestParam String name, @RequestParam(required = false) String lastName){
        EmployeeDTOReq employeeDTOReq = new EmployeeDTOReq(name, lastName);
        Employee employee = new Employee(name, lastName);
        return employee;
    }

    @GetMapping("/crear")
    public ResponseEntity<EmployeeDTORes> createEmployee(@RequestBody EmployeeDTOReq employee){
        EmployeeDTORes employeeDTORes = new EmployeeDTORes(employee.getName(), employee.getLastName(), "El empleado fue creado correctamente");
        return new ResponseEntity<>(employeeDTORes, HttpStatus.CREATED);
    }

}
