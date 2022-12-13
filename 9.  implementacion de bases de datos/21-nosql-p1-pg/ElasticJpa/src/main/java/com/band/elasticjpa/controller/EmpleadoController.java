package com.band.elasticjpa.controller;

import com.band.elasticjpa.service.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    public EmpleadoController(IEmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/empleados")
    public ResponseEntity<?> getEmpleados() {
        return new ResponseEntity<>(empleadoService.getAllEmpleados(), HttpStatus.OK);
    }
}
