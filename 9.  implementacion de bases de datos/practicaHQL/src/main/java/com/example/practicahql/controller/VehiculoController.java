package com.example.practicahql.controller;

import com.example.practicahql.dto.VehiculoDTO;
import com.example.practicahql.service.VehiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoServiceImpl service;

    @PostMapping
    public ResponseEntity<VehiculoDTO> create(@RequestBody VehiculoDTO vehiculoDTO){

        return new ResponseEntity<>(service.create(vehiculoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatente(){
        return new ResponseEntity<>(service.findPatentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes/marca")
    public ResponseEntity<List<String>> getPatenteMarca(){
        return new ResponseEntity<>(service.findPatentesMarca(), HttpStatus.OK);
    }
}
