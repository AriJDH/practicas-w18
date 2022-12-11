package com.example.hqlvehiculos.controller;

import com.example.hqlvehiculos.DTO.SiniestroDto;
import com.example.hqlvehiculos.service.SiniestroSeviceImp;
import com.example.hqlvehiculos.service.VehiculoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {
    @Autowired
    private SiniestroSeviceImp implementacioService; //cambiar por Siniestro

    //crear vehiculo
    @PostMapping()
    public ResponseEntity<SiniestroDto> create(@RequestBody SiniestroDto siniestro){
        return new ResponseEntity<>(implementacioService.createSiniestro(siniestro), HttpStatus.CREATED);
    }
}
