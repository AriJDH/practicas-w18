package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.response.PlatoResponseDto;
import com.example.calculadoracalorias.service.IPlatoService;
import com.example.calculadoracalorias.service.PlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Restaurante")
public class PlatoController {
    IPlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/{menu}/{peso}")
    public ResponseEntity<PlatoResponseDto> mostrarCalorias(@PathVariable String menu, @PathVariable float peso){
        return new ResponseEntity<>(platoService.platoCalorias(menu,peso), HttpStatus.OK);
    }

    @GetMapping("/listaCalorias/{peso}")
    public ResponseEntity<List<PlatoResponseDto>> mostrarListaCalorias(@PathVariable float peso){
        return new ResponseEntity<>(platoService.listaPlatoCalorias(peso),HttpStatus.OK);
    }
}
