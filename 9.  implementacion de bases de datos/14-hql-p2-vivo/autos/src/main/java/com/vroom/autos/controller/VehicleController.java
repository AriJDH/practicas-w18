package com.vroom.autos.controller;

import com.vroom.autos.service.IVehicleService;
import com.vroom.autos.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle/plates")
    public ResponseEntity<?> getVehicleLicensePlateList() {
        return new ResponseEntity<>(vehicleService.getVehicleLicensePlateList(), HttpStatus.OK);
    }
    @GetMapping("/vehicle/fab")
    public ResponseEntity<?> getVehicleLicensePlateMakeListOrderByFabricationYear() {
        return new ResponseEntity<>(vehicleService.getVehicleLicensePlateMakeListOrderByFabricationYear(), HttpStatus.OK);
    }
    @GetMapping("/vehicle/wheels")
    public ResponseEntity<?> getVehicleLicensePlateWhereWheelCountGreaterThanAndFabricationYearIs() {
        return new ResponseEntity<>(vehicleService.getVehicleLicensePlateWhereWheelCountGreaterThanAndFabricationYearIs(), HttpStatus.OK);
    }
    @GetMapping("/vehicle/loss")
    public ResponseEntity<?> getVehicleWhereAccidentMonetaryLossGreaterThan() {
        return new ResponseEntity<>(vehicleService.getVehicleWhereAccidentMonetaryLossGreaterThan(), HttpStatus.OK);
    }
}
