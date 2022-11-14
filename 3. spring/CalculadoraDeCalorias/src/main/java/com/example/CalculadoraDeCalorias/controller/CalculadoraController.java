package com.example.CalculadoraDeCalorias.controller;

import com.example.CalculadoraDeCalorias.dto.in.PlatoDtoIn;
import com.example.CalculadoraDeCalorias.dto.out.PlatoDtoOut;
import com.example.CalculadoraDeCalorias.services.ICalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculadoraController {

    @Autowired
    ICalculadoraService calculadoraService;

    @GetMapping
    public ResponseEntity<List<PlatoDtoOut>> platoFinal(@RequestBody List<PlatoDtoIn> platoList){
        return ResponseEntity.ok().body(calculadoraService.platoFinal(platoList));
    }

}
