package com.jcundere.ejerciciopractico07c.controller;

import com.jcundere.ejerciciopractico07c.dto.request.VehicleRequest;
import com.jcundere.ejerciciopractico07c.dto.response.VehicleResponse;
import com.jcundere.ejerciciopractico07c.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @PostMapping("v1/api/vehicles")
    public ResponseEntity<String> createVehicle(@RequestBody VehicleRequest request) {

        vehicleService.saveVehicle(request);
        return new ResponseEntity<>("Vehiculo Guardado !", HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable Integer id) {

        VehicleResponse response = vehicleService.getVehicleById(id).get();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles")
    public ResponseEntity<List<VehicleResponse>> getAllVehicle() {

        List<VehicleResponse> response = vehicleService.getAllVehicle();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/prices")
    public ResponseEntity<List<VehicleResponse>> getAllVehicleFilterByPriceRange(@RequestParam(name = "since", defaultValue = "0") Integer minValue,
                                                                                 @RequestParam(name = "to", defaultValue = "0") Integer maxValue) {

        List<VehicleResponse> response = vehicleService.getAllVehicleByPriceRange(minValue, maxValue);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<List<VehicleResponse>> getAllVehicleFilterByDateRange(@RequestParam(name = "since", defaultValue = "0") String startDate,
                                                                                @RequestParam(name = "to", defaultValue = "0") String endDate) {

        List<VehicleResponse> response = vehicleService.getAllVehicleByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
