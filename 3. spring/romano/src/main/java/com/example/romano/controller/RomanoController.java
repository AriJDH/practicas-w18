package com.example.romano.controller;

import com.example.romano.service.NumeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RomanoController {
    @Autowired
    private NumeroService numeroService;

    @GetMapping("/{numeroDecimal}")
    public ResponseEntity<?> decimalARomano(@PathVariable int numeroDecimal){
        return new ResponseEntity<>(numeroService.numeroARomano(numeroDecimal), HttpStatus.OK);
    }
}
