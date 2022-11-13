package com.bootcamp.CarAgency.controller;

import com.bootcamp.CarAgency.dto.view.VehicleFullDto;
import com.bootcamp.CarAgency.dto.view.VehicleWithoutServiceDto;
import com.bootcamp.CarAgency.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired
    private IVehicleService vehicleService;


   @PostMapping
    public ResponseEntity<String> saveVehicle(@RequestBody VehicleFullDto vehicle) {
        vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok("Ok");
    }

    @GetMapping
    public ResponseEntity<List<VehicleWithoutServiceDto>> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleFullDto>> findByManufacturingDate(@RequestParam String manufacturingDate) {
        return new ResponseEntity<>(vehicleService.findByManufacturingDate(manufacturingDate),HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleFullDto>> findByPrice(@RequestParam String price) {
        return new ResponseEntity<>(vehicleService.findByPrice(price),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleFullDto> findById(Integer id) {
        return new ResponseEntity<>(vehicleService.findById(id),HttpStatus.OK);
    }
}
