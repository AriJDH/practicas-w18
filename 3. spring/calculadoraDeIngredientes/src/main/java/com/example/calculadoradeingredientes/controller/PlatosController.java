package com.example.CalculadoraDeIngredientes.controller;

import com.example.CalculadoraDeIngredientes.dto.PlatoDto;
import com.example.CalculadoraDeIngredientes.service.IPlatosService;
import com.example.CalculadoraDeIngredientes.service.PlatosServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatosController {
    private IPlatosService service;

    public PlatosController(PlatosServiceImp platosServiceImp) {
        this.service = platosServiceImp;
    }

    @GetMapping("/platos")
    public ResponseEntity<List<PlatoDto>> findAll() {
        List<PlatoDto> platoList = service.getAll();
        return new ResponseEntity<>(platoList, HttpStatus.OK);
    }
}
