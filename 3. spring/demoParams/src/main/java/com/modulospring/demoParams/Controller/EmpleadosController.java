package com.modulospring.demoParams.Controller;

import com.modulospring.demoParams.DTO.request.EmployeeDTOReq;
import com.modulospring.demoParams.DTO.response.EmpoyeeDTOResp;
import com.modulospring.demoParams.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadosController {
    @GetMapping("/employee/{name}/{lastname}")
    public Employee getEmployee(@PathVariable String name, @PathVariable String lastname){
        Employee employee = new Employee(name, lastname);
        return  employee;
    }
    @GetMapping("/employee")
    public Employee findEmplloyee (@RequestParam String name, @RequestParam(required = false) String lastname){
        Employee employee = new Employee(name,lastname);
        return employee;
    }
    @PostMapping("/crear")
    public ResponseEntity<EmpoyeeDTOResp> crearEmployee(@RequestBody EmployeeDTOReq employee){
    EmpoyeeDTOResp empoyeeDTOResp = new EmpoyeeDTOResp(employee.getName(), employee.getLastname(),  "Se creo empleado");
        return new ResponseEntity<>(empoyeeDTOResp, HttpStatus.CREATED);
    }
}


