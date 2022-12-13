package com.example.empresaseguro.controller;

import com.example.empresaseguro.dto.request.VehiculoDTORequest;
import com.example.empresaseguro.service.IServiceVehiculo;
import com.example.empresaseguro.service.ServiceVehiculoImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class VehiculoController {

    IServiceVehiculo serviceVehiculo;
    public VehiculoController(ServiceVehiculoImp serviceVehiculo){
        this.serviceVehiculo=serviceVehiculo;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VehiculoDTORequest vehiculoDTORequest){
        serviceVehiculo.crearVehiculo(vehiculoDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(serviceVehiculo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(serviceVehiculo.findById(id),HttpStatus.OK);
    }
}
