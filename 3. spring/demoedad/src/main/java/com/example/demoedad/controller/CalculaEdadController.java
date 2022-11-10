package com.example.demoedad.controller;

import com.example.demoedad.DTO.response.EmployeeDTORes;
import com.example.demoedad.DTO.resquest.EmployeeDTOReq;
import com.example.demoedad.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculaEdadController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public String queEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){
        LocalDate fechaNacimiento =  LocalDate.of(ano,mes,dia);
        LocalDate fechaHoy = LocalDate.now();
        int edad = Period.between(fechaNacimiento,fechaHoy).getYears();
        return String.valueOf(edad);
    }

    @GetMapping("/employee/{name}/{lastName}")
    public Employee getEmpleado(@PathVariable String nombre, @PathVariable String apellido){
        Employee employee = new Employee(nombre,apellido);
        return employee;
    }

    @GetMapping("/employee")
    public Employee findEmpleado(@RequestParam String nombre, @PathVariable(required = false) String apellido){
        Employee employee = new Employee(nombre,apellido);
        return employee;
    }

    @PostMapping("/crear")
    public ResponseEntity<EmployeeDTORes> crearEmpleado(@RequestBody EmployeeDTOReq empleado){
        EmployeeDTORes employeeDTORes =
                new EmployeeDTORes(empleado.getNombre(),
                empleado.getApellido(),
                "El mensaje fue creado correctamente");
        return new ResponseEntity<>(employeeDTORes,HttpStatus.OK);
    }
}
