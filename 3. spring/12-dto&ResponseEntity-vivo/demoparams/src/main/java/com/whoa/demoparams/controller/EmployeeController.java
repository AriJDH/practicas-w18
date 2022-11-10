package com.whoa.demoparams.controller;

import com.whoa.demoparams.dto.request.EmployeeDTOReq;
import com.whoa.demoparams.dto.response.EmployeeDTORes;
import com.whoa.demoparams.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @GetMapping("employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name,
                                @PathVariable String lastname) {
        Employee employee = new Employee(name, lastname);
        return employee;
    }

    @GetMapping("/employee")
    public Employee findEmployee(@RequestParam String name,
                                 @RequestParam String lastname) {
        Employee employee = new Employee(name, lastname);
        return employee;
    }

    @PostMapping("/crear")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setName(employee.getName() + "isMyName");
        return employee;
    }

    @PostMapping("/add/dto")
    public ResponseEntity<EmployeeDTORes> addEmployee(@RequestBody EmployeeDTOReq employee) {
        EmployeeDTORes employeeDTORes = new EmployeeDTORes(employee.getLastname(), employee.getName(), "Creado, todo bien!!");
        return new ResponseEntity<>(employeeDTORes, HttpStatus.CREATED);
    }
}
