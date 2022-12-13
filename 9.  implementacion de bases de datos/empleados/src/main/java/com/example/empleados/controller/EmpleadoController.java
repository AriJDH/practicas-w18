package com.example.empleados.controller;

import com.example.empleados.domain.Empleado;
import com.example.empleados.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> findAll(){
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        empleadoService.deleteById(id);
        return ResponseEntity.ok("El empleado " + id + "fue eliminado.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> findById(@PathVariable String id){
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable String id,@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.update(id,empleado));
    }
}
