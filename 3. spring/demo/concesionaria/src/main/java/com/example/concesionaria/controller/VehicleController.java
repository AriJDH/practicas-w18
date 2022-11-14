package com.example.concesionaria.controller;


import com.example.concesionaria.dto.ServiceDTO;
import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.VehicleDTOres;
import com.example.concesionaria.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(VehicleDTO vehicleDTO){
      vehicleService.addVehicle(vehicleDTO);
      return new ResponseEntity<VehicleDTO>(vehicleDTO, HttpStatus.CREATED);
    }

    @PostMapping("/vehicles/service/{id}")
    public ResponseEntity<?> addServiceToVehicle(
            @RequestParam int id,
            @RequestBody ServiceDTO serviceDTO){
        vehicleService.addServiceToVehicle(serviceDTO, id);
        return new ResponseEntity<ServiceDTO>(serviceDTO, HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        List<VehicleDTOres> vehicles = vehicleService.getVehicles();
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<?> getVehiclesByDates(
            @RequestParam(name="since") String since,
            @RequestParam(name="to") String to) {

        List<VehicleDTOres> res = vehicleService.getVehiclesByDates(since, to);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<?> getVehiclesByPrices(
            @RequestParam(name="since") int since,
            @RequestParam(name="to") int to) {

        List<VehicleDTOres> res = vehicleService.getVehiclesByPrice(since, to);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable int id){
        VehicleDTO res = vehicleService.getVehicleById(id);
        return ResponseEntity.ok().body(res);
    }
}
