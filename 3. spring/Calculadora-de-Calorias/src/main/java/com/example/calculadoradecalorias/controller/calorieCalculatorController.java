package com.example.calculadoradecalorias.controller;

import com.example.calculadoradecalorias.dto.request.PlateDTOreq;
import com.example.calculadoradecalorias.dto.response.PlateDTOres;
import com.example.calculadoradecalorias.service.IPlateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class calorieCalculatorController {

    IPlateService plateService;

    calorieCalculatorController(IPlateService plateService){
        this.plateService = plateService;
    }

    @PostMapping(path = "/plate")
    public ResponseEntity<PlateDTOres> getPlateData(@RequestBody PlateDTOreq plate){
        return new ResponseEntity(plateService.getPlateData(plate), HttpStatus.FOUND) ;
    }

    @PostMapping(path = "/plates")
    public ResponseEntity<List<PlateDTOres>> getPlatesDataByList(@RequestBody List<PlateDTOreq> plates){
        return new ResponseEntity(plateService.getPlatesData(plates), HttpStatus.FOUND);
    }




}
