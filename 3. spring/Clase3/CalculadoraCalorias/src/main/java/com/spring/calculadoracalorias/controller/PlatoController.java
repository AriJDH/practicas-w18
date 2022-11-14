package com.spring.calculadoracalorias.controller;

import com.spring.calculadoracalorias.dto.PlatoDTO;
import com.spring.calculadoracalorias.service.IPlatoServicio;
import com.spring.calculadoracalorias.service.PlatoServicioImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    private IPlatoServicio platoServicio;

    public PlatoController(PlatoServicioImp platoServicioImp){
        this.platoServicio = platoServicioImp;
    }

    @GetMapping("/{nombre}/{peso}")
    public ResponseEntity<PlatoDTO> buscarPlato(@PathVariable String nombre, @PathVariable int peso){
        return new ResponseEntity<>(platoServicio.buscarPlato(nombre, peso), HttpStatus.OK);
    }
}
