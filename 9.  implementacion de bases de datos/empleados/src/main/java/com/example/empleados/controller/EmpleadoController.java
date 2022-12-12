package com.example.empleados.controller;

import com.example.empleados.domain.Empleado;
import com.example.empleados.service.EmpleadoDbService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.ExemptionMechanism;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoDbService empleadoDbService;

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoDbService.save(empleado));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> findAll(){
        return ResponseEntity.ok(empleadoDbService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        empleadoDbService.deleteById(id);
        return ResponseEntity.ok("El empleado " +id + " fue eliminado");
    }
}
