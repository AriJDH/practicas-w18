package com.example.concesionarioautos.controller;

import com.example.concesionarioautos.dto.request.AutoRequestDTO;
import com.example.concesionarioautos.dto.response.AutoResponseDTO;
import com.example.concesionarioautos.dto.response.AutoSoloResponseDTO;
import com.example.concesionarioautos.service.IAutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConsesionariaController {

    private final IAutoService autoService;

    public ConsesionariaController(IAutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("v1/api/vehicles")
    public ResponseEntity<List<AutoSoloResponseDTO>> listAll(){
        return new ResponseEntity<>(autoService.listAll(), HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<AutoResponseDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(autoService.findById(id), HttpStatus.OK);
    }

    @PostMapping("v1/api/vehicles/")
    public ResponseEntity<AutoResponseDTO> addVehicle(@RequestBody AutoRequestDTO auto){
        return new ResponseEntity<>(autoService.add(auto), HttpStatus.CREATED);
    }

    @GetMapping("v1/api/vehicles/dates")
    public List<ResponseEntity<AutoResponseDTO>> findByYear(@RequestParam int since, @RequestParam int to){
        return autoService.findByYear(since, to).stream().map(a-> new ResponseEntity<>(a,HttpStatus.OK)).collect(Collectors.toList());
    }

    @GetMapping("v1/api/vehicles/prices")
    public List<ResponseEntity<AutoResponseDTO>> findeByPrice(@RequestParam double since, @RequestParam double to){
        return autoService.findeByPrice(since, to).stream().map(a-> new ResponseEntity<>(a,HttpStatus.OK)).collect(Collectors.toList());
    }

}
