package com.example.practicablogexcepciones.controller;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;
import com.example.practicablogexcepciones.service.EntradaBlogServiceImp;
import com.example.practicablogexcepciones.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntradaBlogController {

    private IEntradaBlogService entradaBlogService;

    public EntradaBlogController(EntradaBlogServiceImp entradaBlogServiceImp){
        this.entradaBlogService = entradaBlogServiceImp;
    }

// Nueva entrada del blog
    @PostMapping("/blog")
    public ResponseEntity<String>  agregarEntrada(@RequestBody EntradaBlogDto entradaBlogDto){
        // TODO agregar la excepcion si ya existe la entrada
        entradaBlogService.crearEntradaBlog(entradaBlogDto);
        return new ResponseEntity<>("Entrada creada con éxito", HttpStatus.CREATED);
    }

// Buscar un blog especifico
    @GetMapping("/blog/{id}")
    public ResponseEntity<>
}
