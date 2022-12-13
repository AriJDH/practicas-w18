package com.example.empresa_elasticsearch.controller;

import com.example.empresa_elasticsearch.domain.Empleado;
import com.example.empresa_elasticsearch.dto.CreacionEmpleadoDTO;
import com.example.empresa_elasticsearch.dto.ModificacionEmpleadoDTO;
import com.example.empresa_elasticsearch.repository.EmpleadoRepository;
import com.example.empresa_elasticsearch.service.IEmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    private IEmpleadoService iEmpleadoService;

    private EmpleadoRepository empleadoRepository;

    public EmpleadoController(IEmpleadoService iEmpleadoService, EmpleadoRepository empleadoRepository) {
        this.iEmpleadoService = iEmpleadoService;
        this.empleadoRepository = empleadoRepository;
    }

    @PostMapping("/crearEmpleado")
    public ResponseEntity<?> crearEmpleado(@RequestBody CreacionEmpleadoDTO creacionEmpleadoDTO) {
        return ResponseEntity.ok(this.iEmpleadoService.crearEmpleado(creacionEmpleadoDTO));
    }

    @PostMapping("/modificarEmpleado")
    public ResponseEntity<?> modificarEmpleado(@RequestBody ModificacionEmpleadoDTO modificacionEmpleadoDTO) {
        return ResponseEntity.ok(this.iEmpleadoService.modificarEmpleado(modificacionEmpleadoDTO));
    }

    @GetMapping("/consultarEmpleadoPorNombre")
    public ResponseEntity<?> consultarEmpleadoPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(this.empleadoRepository.findByNombreUnico(nombre));
    }
}
