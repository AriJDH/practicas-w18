package com.example.siniestros.controlller;

import com.example.siniestros.DTOs.*;
import com.example.siniestros.service.VehiculoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoDbService vehiculoDbService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        vehiculoDbService.createVehiculo(vehiculoDTO);
        return ResponseEntity.ok(new ResponseDTO("El vehículo fue creado con éxito.", 200));
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> findAllPatentes(){
        return ResponseEntity.ok(vehiculoDbService.findAllPatentes());
    }

    @GetMapping("/patentes_marcas")
    public ResponseEntity<List<PatenteMarcaDTO>> findAllPatentesAndMarcas(){
        return ResponseEntity.ok(vehiculoDbService.findAllPatentesAndMarcas());
    }

    @GetMapping("/patentes_vehiculos_cuatro_ruedas")
    public ResponseEntity<List<String>> findAllPatentesVehiculosCuatroRuedas(){
        return ResponseEntity.ok(vehiculoDbService.findAllPatentesVehiculo4Ruedas());
    }

    @GetMapping("/patentes_marcas_modelos")
    public ResponseEntity<List<PatenteMarcaModeloDTO>> findAllPatentesMarcasModelos(){
        return ResponseEntity.ok(vehiculoDbService.findAllPatenteMarcaModelo());
    }
    @GetMapping("/patentes_marcas_modelos_total")
    public ResponseEntity<PatenteMarcaModeloTotalDTO> findAllPatentesMarcasModelosTotal(){
        return ResponseEntity.ok(vehiculoDbService.findAllPatenteMarcaModeloPerdidaPerdidaMayor10000TotalGastado());
    }
}
