package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.PlatoDto;
import com.example.calculadoracalorias.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    private IPlatoService platoService;

    public PlatoController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/consultarPlato/{nombre}/{peso}")
    public ResponseEntity<PlatoDto> consultarPlato(@PathVariable String nombre, @PathVariable Integer peso) {
        return new ResponseEntity<>(this.platoService.consultarPlato(nombre, peso), HttpStatus.OK);
    }
}
