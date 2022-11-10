package com.example.covid.controllers;

import com.example.covid.domain.Sintoma;
import com.example.covid.domain.dtos.SintomaDTO;
import com.example.covid.repositories.RepositoryFactory;
import com.example.covid.repositories.SintomaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sintomas")
public class SintomaController {
    SintomaRepository sintomaRepository = RepositoryFactory.getSintomaRepository();

    @GetMapping
    public ResponseEntity<List<SintomaDTO>> getSintomas(){
        return new ResponseEntity<>(sintomaRepository.findAll().stream().map(s->s.toDTO())
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable String name){
        Optional<Sintoma> optionalSintoma = sintomaRepository.findSintomaByName(name);
        if(optionalSintoma.isPresent())
            return new ResponseEntity<>(optionalSintoma.get().toDTO(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().header("Resultado","El síntoma pedido no existe.").build();
    }
}
