package com.example.elasticsearchspringempleados.controller;

import com.example.elasticsearchspringempleados.domain.Empleado;
import com.example.elasticsearchspringempleados.repostiroy.IEmpleadoRepository;
import com.example.elasticsearchspringempleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado){
        return new ResponseEntity<>(service.create(empleado), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
        return new ResponseEntity<>(service.update(empleado), HttpStatus.OK);
    }
}
