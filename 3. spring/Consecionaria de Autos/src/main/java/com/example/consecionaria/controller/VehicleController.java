package com.example.consecionaria.controller;


import com.example.consecionaria.dto.req.VehicleDTOReq;
import com.example.consecionaria.dto.resp.VehicleDTOResp;
import com.example.consecionaria.service.IVehicleService;
import com.example.consecionaria.service.VehicleServiceImp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vehicles")

public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImp vehicleServiceImp){
        this.vehicleService = vehicleServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTOResp>> getAll() {
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>createdVehicle(@RequestBody VehicleDTOReq vehicleDTOReq){
        vehicleService.createdVehicle(vehicleDTOReq);
        return new ResponseEntity<>("Vehiculo Creado", HttpStatus.CREATED);
    };

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTOResp> getById(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.getById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTOResp>>getByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date since,
                                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date to){
        return new ResponseEntity<>(vehicleService.getByDate(since, to),HttpStatus.OK);
    }
}
