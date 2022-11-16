package com.example.deportes.controllers;

import com.example.deportes.dto.DeportesDTO;
import com.example.deportes.service.DeportesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteControllers {
    private DeportesService deportesService = new DeportesService();

    @GetMapping("/deportes/todos")
    public ResponseEntity<List<DeportesDTO>> traerTodosLosDeportes(){
        return ResponseEntity.ok(deportesService.buscarTodos());
    }
}
