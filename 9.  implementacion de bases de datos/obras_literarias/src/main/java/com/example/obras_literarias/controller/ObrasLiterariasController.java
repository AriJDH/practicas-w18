package com.example.obras_literarias.controller;

import com.example.obras_literarias.dto.ObrasLiterariasDTO;
import com.example.obras_literarias.service.IObrasLiterariasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObrasLiterariasController {

    final IObrasLiterariasService obrasLiterariasService;

    public ObrasLiterariasController(IObrasLiterariasService obrasLiterariasService) {
        this.obrasLiterariasService = obrasLiterariasService;
    }

    @PostMapping("/obra")
    public ResponseEntity<?> save(ObrasLiterariasDTO obrasLiterariasDTO) {
        obrasLiterariasService.guardarObra(obrasLiterariasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
