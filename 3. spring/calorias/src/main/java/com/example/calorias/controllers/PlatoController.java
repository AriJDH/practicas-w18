package com.example.calorias.controllers;

import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.DTOs.PlatoRequestDTO;
import com.example.calorias.services.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @PostMapping
    ResponseEntity<PlatoDTO> newPlato(@RequestBody PlatoRequestDTO newPlato) {
        return ResponseEntity.ok(platoService.getPlatoDTO(newPlato));
    }

    @PostMapping("/list")
    ResponseEntity<List<PlatoDTO>> newPlatos(@RequestBody List<PlatoRequestDTO> newPlatos){
        return ResponseEntity.ok(platoService.getPlatosDTOsFromList(newPlatos));
    }

}
