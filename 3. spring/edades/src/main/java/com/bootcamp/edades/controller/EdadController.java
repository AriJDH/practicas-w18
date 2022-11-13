package com.bootcamp.edades.controller;


import com.bootcamp.edades.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class EdadController {

    @Autowired
    private EdadService service;

    @GetMapping("/{dia}/{mes}/{ano}")
    public ResponseEntity<String> anosDeEdad(@PathVariable("dia") int dia,@PathVariable("mes") int mes,@PathVariable("ano") int ano){
       return new ResponseEntity<>(service.anosDeEdad(dia,mes,ano),HttpStatus.OK);

    }
}
