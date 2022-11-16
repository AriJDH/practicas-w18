package com.example.calculadora.controller;

import com.example.calculadora.dto.req.PlateDTOReq;
import com.example.calculadora.dto.res.PlateDTORes;
import com.example.calculadora.service.IPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlateController {

    private IPlateService plateService;

    @Autowired
    public PlateController(IPlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping("/plates")
    public ResponseEntity<PlateDTORes> getData(@RequestBody PlateDTOReq plateDTO){
        return new ResponseEntity<>(plateService.getData(plateDTO), HttpStatus.OK);
    }
}
