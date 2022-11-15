package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.request.PlatoRequestDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseAddOkDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseDTO;
import com.example.calculadoracalorias.service.IServicePlatos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatoController {
    private IServicePlatos servicePlatos;

    public PlatoController(IServicePlatos servicePlatos) {
        this.servicePlatos = servicePlatos;
    }

    @GetMapping("/platos")
    public ResponseEntity<List<PlatoResponseDTO>> listAll(){
        return new ResponseEntity<>(servicePlatos.listAll(), HttpStatus.OK);
    }

    /*
    @GetMapping("/plato/{name}/{peso}")
    public ResponseEntity<PlatoResponseDTO> findByName(@PathVariable String name, @PathVariable Integer peso){
        return new ResponseEntity<>(servicePlatos.findByNamePeso(name, peso), HttpStatus.OK);
    }

     */

    @GetMapping("/plato/{name}")
    public ResponseEntity<PlatoResponseDTO> findByName(@PathVariable String name){
        return new ResponseEntity<>(servicePlatos.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlatoResponseAddOkDTO> addPlato(@RequestBody PlatoRequestDTO plato){
        return new ResponseEntity<>(servicePlatos.add(plato), HttpStatus.CREATED);
    }
}
