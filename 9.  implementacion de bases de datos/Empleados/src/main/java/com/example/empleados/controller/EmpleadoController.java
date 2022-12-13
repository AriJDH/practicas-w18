package com.example.empleados.controller;

import com.example.empleados.dto.EmpleadoDto;
import com.example.empleados.dto.Response;
import com.example.empleados.service.imp.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/empleados")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(empleadoService.create(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(empleadoService.update(empleado), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmpleadoDto>> findAll() {
        return ResponseEntity.ok().body(empleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDto> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(empleadoService.findById(id));
    }
}
