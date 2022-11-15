package com.example.practicablogexcepciones.controller;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;
import com.example.practicablogexcepciones.service.EntradaBlogServiceImp;
import com.example.practicablogexcepciones.service.IEntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        entradaBlogService.add(entradaBlogDto);
        return new ResponseEntity<>("Entrada creada con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDto>> getAll(){
        return new ResponseEntity<>(this.entradaBlogService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.entradaBlogService.findOne(id), HttpStatus.OK);
    }
}
