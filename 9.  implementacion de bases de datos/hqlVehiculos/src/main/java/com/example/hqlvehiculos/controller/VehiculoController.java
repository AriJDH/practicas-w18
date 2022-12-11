package com.example.hqlvehiculos.controller;

import com.example.hqlvehiculos.DTO.VehiculoDto;
import com.example.hqlvehiculos.service.VehiculoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoServiceImp implementacioService;

    //crear vehiculo
    @PostMapping()
    public ResponseEntity<VehiculoDto> create(@RequestBody VehiculoDto vehicle){
        return new ResponseEntity<>(implementacioService.create(vehicle), HttpStatus.CREATED);
    }

    //Listado de todas las patentes
    @GetMapping("/patentes")
    public ResponseEntity<List<String>> getPatentes(){
        return new ResponseEntity<>(implementacioService.findPatentes(), HttpStatus.OK);
    }

    //Listado de patentes y marcas ordenados por año de fabricación
    @GetMapping("/patentes/marca")
    public ResponseEntity<List<String>> getPatentesMarca(){
        return new ResponseEntity<>(implementacioService.findPatentesMarca(), HttpStatus.OK);
    }

    //Listar la patente de todos los vehículos que
    //tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.

    @GetMapping("/patentes/ruedas")
    public ResponseEntity<List<String>> getPatentesRuedas(){
        return new ResponseEntity<>(implementacioService.getPatentesRuedas(), HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo
    //de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/patentes/perdida")
    public ResponseEntity<List<String>> getPatenteMarcaModeloSiniestro() {
        return new ResponseEntity<>(implementacioService.getPatenteMarcaModeloSiniestro(), HttpStatus.OK);
    }

}
