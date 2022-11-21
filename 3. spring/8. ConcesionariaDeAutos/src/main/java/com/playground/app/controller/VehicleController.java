package com.playground.app.controller;

import com.playground.app.dto.request.VehicleDTOReq;
import com.playground.app.dto.response.VehicleDTOResp;
import com.playground.app.service.IVehicleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;  //de esta forma hago inversion de control
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTOResp>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehicleDTOReq vehicleDTOReq){
        vehicleService.createVehicle(vehicleDTOReq);
        return new ResponseEntity<>("Vehiculo Creado", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTOResp> getById(@PathVariable Integer id){
        return new ResponseEntity<> (vehicleService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTOResp>> getByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
                                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to){
        return new ResponseEntity<> (vehicleService.getByDates(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTOResp>> getByPrice(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>( vehicleService.getByPrice(since, to), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        vehicleService.deleteById(id);
        return new ResponseEntity<>("Eliminado con Exito", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody VehicleDTOReq vehicleDTOReq,
                                         @PathVariable Integer id) {
        vehicleService.update(vehicleDTOReq, id);
        return new ResponseEntity<>("Modificado con éxito", HttpStatus.OK);
    }

}// cierre
