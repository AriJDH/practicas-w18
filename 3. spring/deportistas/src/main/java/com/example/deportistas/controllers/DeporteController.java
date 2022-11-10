package com.example.deportistas.controllers;

import com.example.deportistas.DTOs.DeporteDTO;
import com.example.deportistas.domain.Deporte;
import com.example.deportistas.repositories.DeporteRepository;
import com.example.deportistas.repositories.RepositoryFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/deportes")
public class DeporteController {
    private DeporteRepository deporteRepository = RepositoryFactory.getDeporteRepository();

    @GetMapping
    public ResponseEntity<List<DeporteDTO>> getDeportes(){
        return ResponseEntity
                .ok(deporteRepository.findAll().stream().map(d-> new DeporteDTO(d)).collect(Collectors.toList()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<DeporteDTO> getDeporte(@PathVariable String name){
        Optional<Deporte> optionalDeporte = deporteRepository.findDeporteByName(name);
        if(optionalDeporte.isPresent())
            return ResponseEntity.ok(new DeporteDTO(optionalDeporte.get()));
        else
            return ResponseEntity.notFound().header("Resultado","El deporte no existe").build();
    }
}
