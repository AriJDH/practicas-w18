package com.example.empleados.controller;

import com.example.empleados.dto.request.EmpleadoRequest;
import com.example.empleados.dto.response.EmpleadoResponse;
import com.example.empleados.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoService;


    @PostMapping("/crear")
    public ResponseEntity<EmpleadoResponse> createEmpleado(@RequestBody EmpleadoRequest request) {

        return new ResponseEntity<>(empleadoService.createEmpleado(request), HttpStatus.OK);
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<EmpleadoResponse> updateEmpleado(@PathVariable String id, @RequestBody EmpleadoRequest request) {

        return new ResponseEntity<>(empleadoService.updateEmpleado(id, request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmpleado() {

        return new ResponseEntity<>(empleadoService.getAllEmpleado(), HttpStatus.OK);
    }

}
