package com.example.seguros.controller;

import com.example.seguros.dto.request.SiniestroDTOReq;
import com.example.seguros.dto.request.VehiculoDTOReq;
import com.example.seguros.dto.response.SiniestroDTORes;
import com.example.seguros.dto.response.VehiculoDTORes;
import com.example.seguros.model.entity.VehiculoSiniestro;
import com.example.seguros.service.ISiniestroService;
import com.example.seguros.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    IVehiculoService vehiculoService;
    ISiniestroService siniestroService;

    public VehiculoController(IVehiculoService vehiculoService, ISiniestroService siniestroService) {
        this.vehiculoService = vehiculoService;
        this.siniestroService = siniestroService;
    }

    @PostMapping("/crear/vehiculo")
    ResponseEntity<VehiculoDTORes> createVehiculo(@RequestBody VehiculoDTOReq vehiculoDTOReq) {
        return new ResponseEntity<>(vehiculoService.createVehiculo(vehiculoDTOReq), HttpStatus.CREATED);
    }

    @PostMapping("/crear/siniestro")
    ResponseEntity<SiniestroDTORes> createSiniestro(@RequestBody SiniestroDTOReq siniestroDTOReq) {
        return new ResponseEntity<>(siniestroService.createSiniestro(siniestroDTOReq), HttpStatus.CREATED);
    }


    @GetMapping("/listar")
    ResponseEntity<List<VehiculoDTORes>> findAllVehiculos() {
        return new ResponseEntity<>(vehiculoService.findAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/listar/consulta1")
    ResponseEntity<List<String[]>> findByPatente() {
        return new ResponseEntity<>(vehiculoService.findByPatente(), HttpStatus.OK);
    }

    /*@GetMapping("/listar/consulta2")
    ResponseEntity<List<PatenteAndMarca>> finByPatenteAndMarca() {
        return new ResponseEntity<>(vehiculoService.findByPatenteAndMarca(), HttpStatus.OK);
    }*/

    /*@GetMapping("/listar/consulta2")
    ResponseEntity<List<HashMap<String, String>>> finByPatenteAndMarca() {
        return new ResponseEntity<>(vehiculoService.findByPatenteAndMarca(), HttpStatus.OK);
    }*/

    @GetMapping("/listar/consulta2")
    ResponseEntity<List<String[]>> finByPatenteAndMarca() {
        return new ResponseEntity<>(vehiculoService.findByPatenteAndMarca(), HttpStatus.OK);
    }

    @GetMapping("/listar/consulta3")
    ResponseEntity<List<String[]>> findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022() {
        return new ResponseEntity<>(vehiculoService.findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022(), HttpStatus.OK);
    }

    @GetMapping("/listar/consulta4")
    ResponseEntity<List<String[]>> finByPatenteAndMarcaAndModelo() {
        return new ResponseEntity<>(vehiculoService.findByPatenteAndMarcaAndModelo(), HttpStatus.OK);
    }

    @GetMapping("/listar/consulta5")
    ResponseEntity<List<VehiculoSiniestro>> findVehiculoSiniestro() {
        return new ResponseEntity<>(vehiculoService.findVehiculoSiniestro(), HttpStatus.OK);
    }
}
