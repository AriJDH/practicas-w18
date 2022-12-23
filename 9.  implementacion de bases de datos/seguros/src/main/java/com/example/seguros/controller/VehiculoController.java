package com.example.seguros.controller;

import com.example.seguros.dto.PatentesDTO;
import com.example.seguros.dto.PatentesMarcaDTO;
import com.example.seguros.dto.PatentesMarcaModeloDTO;
import com.example.seguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Vehiculo")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/patentes")
    public ResponseEntity<PatentesDTO> findPatentes() {
        return ResponseEntity.ok(vehiculoService.findPatentes());
    }

    @GetMapping("/patentesymarca")
    public ResponseEntity<List<PatentesMarcaDTO>> findPatentesMarca() {
        return ResponseEntity.ok(vehiculoService.findPatentesMarca());
    }

    @GetMapping("/patentes/query")
    public ResponseEntity<PatentesDTO> findPatentesByRuedasAndAnio() {
        return ResponseEntity.ok(vehiculoService.findPatentesByRuedasAndAnio());
    }

    @GetMapping("/patentes/monto")
    public ResponseEntity<List<PatentesMarcaModeloDTO>> vehiculosBySinisterMount() {
        return ResponseEntity.ok(vehiculoService.listVehiclesBySinisterMount());
    }
}
