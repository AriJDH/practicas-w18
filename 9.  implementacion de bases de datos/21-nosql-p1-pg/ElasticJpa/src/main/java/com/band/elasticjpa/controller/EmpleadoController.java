package com.band.elasticjpa.controller;

import com.band.elasticjpa.dto.EmpleadoDto;
import com.band.elasticjpa.dto.EmpleadoNameListRequest;
import com.band.elasticjpa.service.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/empleados")
    public ResponseEntity<?> addEmpleado(@RequestBody EmpleadoDto empleadoDto) {
        return new ResponseEntity<>(empleadoService.addEmpleado(empleadoDto), HttpStatus.OK);
    }

    @GetMapping("/empleados/find")
    public ResponseEntity<?> getAllEmpleadosByNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(empleadoService.getAllEmpleadosByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/empleados/findByNamesIn")
    public ResponseEntity<?> getAllEmpleadosByNombreList(@RequestBody EmpleadoNameListRequest empleadoNameListRequest) {
        return new ResponseEntity<>(empleadoService.getAllEmpleadosByNombreList(empleadoNameListRequest), HttpStatus.OK);
    }

    @GetMapping("/empleados/findByEdadGreaterThanEqual")
    public ResponseEntity<?> getAllEmpleadosByEdadGreaterThanEqualOrderByEdad(@RequestParam Integer edad) {
        return new ResponseEntity<>(empleadoService.getAllEmpleadosByEdadGreaterThanEqualOrderByEdadDesc(edad), HttpStatus.OK);
    }

    @GetMapping("/empleados/findAllByProvinciaContains")
    public ResponseEntity<?> getAllEmpleadosByProvinciaContains(@RequestParam String provincia) {
        return new ResponseEntity<>(empleadoService.getAllEmpleadosByProvinciaContains(provincia), HttpStatus.OK);
    }
}