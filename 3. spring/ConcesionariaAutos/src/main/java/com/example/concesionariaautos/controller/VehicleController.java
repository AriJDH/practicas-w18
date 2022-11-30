package com.example.concesionariaautos.controller;

import com.example.concesionariaautos.dto.request.VehicleRequestDto;
import com.example.concesionariaautos.dto.response.ResponseDto;
import com.example.concesionariaautos.dto.response.ResponseVehicleNoServicesDto;
import com.example.concesionariaautos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<ResponseDto> addVehicle(@RequestBody VehicleRequestDto vehicleRequestDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseVehicleNoServicesDto>> getSelectVehicles(){

        return new ResponseEntity<>(vehicleService.getSelectVehicles(),HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByDate(){
        return null;
    }

    @GetMapping("/prices")
    public ResponseEntity<List<ResponseVehicleNoServicesDto>> getVehiclesByPrice(@RequestParam double since, @RequestParam double to){

        return new ResponseEntity<>(vehicleService.getVehiclesByPrice(since,to),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicle(@PathVariable int id){

        return new ResponseEntity<>(vehicleService.getVehicle(id),HttpStatus.OK);
    }

}
