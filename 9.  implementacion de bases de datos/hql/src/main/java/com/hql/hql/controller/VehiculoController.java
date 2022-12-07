package com.hql.hql.controller;

import com.hql.hql.dto.AñoDTO;
import com.hql.hql.dto.ResponseDTO;
import com.hql.hql.dto.VehiculoDTO;
import com.hql.hql.dto.VehiculoDTOReq;
import com.hql.hql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @PostMapping("/vehiculos")
    public ResponseEntity<VehiculoDTO> createVehiculo(@RequestBody VehiculoDTOReq vehiculo){
        return new ResponseEntity<VehiculoDTO>(vehiculoService.createVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<List<VehiculoDTO>> getAllVehiculos(){
        return new ResponseEntity<List<VehiculoDTO>>(vehiculoService.getAllVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/vehiculos/año")
    public ResponseEntity<List<AñoDTO>> findByAñoAllVehiculos(){
        return new ResponseEntity<List<AñoDTO>>(vehiculoService.findByAñoDeFabricacion(), HttpStatus.OK);
    }
}
