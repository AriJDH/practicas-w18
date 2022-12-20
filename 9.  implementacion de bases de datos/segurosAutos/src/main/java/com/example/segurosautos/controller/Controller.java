package com.example.segurosautos.controller;

import com.example.segurosautos.dto.ResponseDto;
import com.example.segurosautos.dto.SiniestroDto;
import com.example.segurosautos.dto.VehiculoDto;
import com.example.segurosautos.service.SiniestroServiceImpl;
import com.example.segurosautos.service.VehiculoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final VehiculoServiceImpl vehiculoService;
    private final SiniestroServiceImpl siniestroService;

    public Controller(VehiculoServiceImpl vehiculoService, SiniestroServiceImpl siniestroService) {
        this.vehiculoService = vehiculoService;
        this.siniestroService = siniestroService;
    }

    @PostMapping("/guardarVehiculo")
    public ResponseEntity<?> guardarVehiculo(@RequestBody VehiculoDto vehiculoDto){
        vehiculoService.addVehiculo(vehiculoDto);
        return new ResponseEntity<>(new ResponseDto("200", "Vehiculo creado exitosamente."), HttpStatus.OK);
    }

    @PostMapping("/guardarSiniestro")
    public ResponseEntity<?> guardarSiniestro(@RequestBody SiniestroDto siniestroDto){
        siniestroService.addSiniestro(siniestroDto);
        return new ResponseEntity<>(new ResponseDto("200", "Siniestro creado exitosamente."), HttpStatus.OK);
    }

    @GetMapping("/listarPatentes")
    public ResponseEntity<?> listarPatentes(){
        return new ResponseEntity<>(vehiculoService.listarPatentes(), HttpStatus.OK);
    }

    @GetMapping("/listarPatentesYMarca")
    public ResponseEntity<?> listarPatentesYMarca(){
        return new ResponseEntity<>(vehiculoService.listarPatenteYMarca(), HttpStatus.OK);
    }

    @GetMapping("/listarPatentesPorRuedasYAnio")
    public ResponseEntity<?> listarPatentesPorRuedasYAnio(){
        return new ResponseEntity<>(vehiculoService.listarPatentesPorRuedasYAnio(), HttpStatus.OK);
    }

    @GetMapping("/listarVehiculosPorPerdidaEconomicaSiniestro")
    public ResponseEntity<?> listarVehiculosPorPerdidaEconomicaSiniestro(){
        return new ResponseEntity<>(siniestroService.listarVehiculosPorPerdidaEconomicaSiniestro(), HttpStatus.OK);
    }

    @GetMapping("/listarVehiculosPorPerdidaEconomicaSiniestroYMonto")
    public ResponseEntity<?> listarVehiculosPorPerdidaEconomicaSiniestroYMonto(){
        return new ResponseEntity<>(siniestroService.listarVehiculosPorPerdidaEconomicaSiniestroYMontoTotal(), HttpStatus.OK);
    }
}
