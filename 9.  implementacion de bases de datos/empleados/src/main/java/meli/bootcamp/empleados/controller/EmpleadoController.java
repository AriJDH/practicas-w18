package meli.bootcamp.empleados.controller;

import meli.bootcamp.empleados.domain.Empleado;
import meli.bootcamp.empleados.repository.IEmpleadoRepository;
import meli.bootcamp.empleados.service.EmpleadoService;
import meli.bootcamp.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    IEmpleadoService empleadoService;
    @Autowired
    IEmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllEmpleados() {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findAll());
    }
    @PostMapping("/save")
    public void saveEmpleado(@RequestBody Empleado empleado) {
        empleadoService.addEmpleado(empleado);
    }

    @PutMapping("/modify/{id}")
    public void modifyEmpleado(@PathVariable String id, @RequestBody Empleado empleado) {
        empleadoService.modifyEmpleado(id, empleado);
    }

    @GetMapping("/test1")
    public ResponseEntity<?> test1(@RequestParam String key) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoRepository.findAllByApellidoIs(key));
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2(@RequestParam List<String> key) {
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.findAllByDescriptionIn(key));
    }
}
