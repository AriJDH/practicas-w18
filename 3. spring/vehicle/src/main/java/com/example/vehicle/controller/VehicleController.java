package com.example.vehicle.controller;

import com.example.vehicle.dto.request.VehicleRequestDTO;
import com.example.vehicle.dto.response.VehicleResponseDTO;
import com.example.vehicle.entity.Vehicle;
import com.example.vehicle.service.IVehicleService;
import com.example.vehicle.service.VehicleServiceImp;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;

    public VehicleController(VehicleServiceImp vehicleServiceImp) {
        this.vehicleService = vehicleServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll(){
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(vehicleService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        vehicleService.addVehicle(vehicleRequestDTO);
        return ResponseEntity.ok("Vehicle successfully added");
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResponseDTO>> findByPrices(@RequestParam Double since,
                                                                 @RequestParam Double to){
        return new ResponseEntity<>(vehicleService.findByPrices(since,to),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Integer id){
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.ok("Vehicle successfully deleted");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Integer id, @RequestBody VehicleRequestDTO vehicleRequestDTO){
        vehicleService.updateVehicle(id, vehicleRequestDTO);
        return ResponseEntity.ok("Vehicle successfully modified");
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResponseDTO>> findByDates(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
                                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {

        return new ResponseEntity<>(vehicleService.findByDates(since,to),HttpStatus.OK);
    }

}
