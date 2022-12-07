package com.example.configurandoJPA.controller;

import com.example.configurandoJPA.model.MiniSerie;
import com.example.configurandoJPA.service.IMiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiniSerieController {
    private final IMiniSerieService miniSerieService;

    public MiniSerieController(IMiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @GetMapping("/findAll")
    ResponseEntity<List<MiniSerie>> findAll(){
        return new ResponseEntity<>(miniSerieService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    ResponseEntity<MiniSerie> findById(@PathVariable Long id){
        return new ResponseEntity<>(miniSerieService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<MiniSerie> create(@RequestBody MiniSerie miniSerie){
        return new ResponseEntity<>(miniSerieService.create(miniSerie),HttpStatus.CREATED);
    }
}
