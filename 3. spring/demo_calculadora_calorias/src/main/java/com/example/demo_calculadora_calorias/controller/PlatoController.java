package com.example.demo_calculadora_calorias.controller;

import com.example.demo_calculadora_calorias.dto.request.PlatoDTOreq;
import com.example.demo_calculadora_calorias.dto.response.PlatoDTOres;
import com.example.demo_calculadora_calorias.service.IPlatoService;
import com.example.demo_calculadora_calorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {

    IPlatoService platoService = new PlatoService();

    @PostMapping("/getPlatoInfoPlato")
    public ResponseEntity<List<PlatoDTOres>> getPlatoInfoPlato(@RequestBody List<PlatoDTOreq> platos){
        return new ResponseEntity<>(platoService.getPlatos(platos), HttpStatus.OK);
    }

}
