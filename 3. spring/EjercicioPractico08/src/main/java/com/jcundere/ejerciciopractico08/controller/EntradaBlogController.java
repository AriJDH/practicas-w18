package com.jcundere.ejerciciopractico08.controller;

import com.jcundere.ejerciciopractico08.dto.request.EntradaBlogRequest;
import com.jcundere.ejerciciopractico08.dto.response.EntradaBlogResponse;
import com.jcundere.ejerciciopractico08.service.IEntradaBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EntradaBlogController {

    private final IEntradaBlogService entradaBlogService;


    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogResponse> createEntradaBlog(@RequestBody EntradaBlogRequest request) {

        EntradaBlogResponse response = entradaBlogService.createEntity(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogResponse> getEntradaBlogById(@PathVariable Integer id) {

        EntradaBlogResponse response = entradaBlogService.getEntityById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogResponse>> getAllEntradaBlog() {

        List<EntradaBlogResponse> response = entradaBlogService.getAllEntity();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
