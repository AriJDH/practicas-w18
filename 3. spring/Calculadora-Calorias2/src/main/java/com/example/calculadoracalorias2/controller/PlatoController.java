package com.example.calculadoracalorias2.controller;

import com.example.calculadoracalorias2.dto.request.PlatoDto;
import com.example.calculadoracalorias2.service.IPlatoService;
import com.example.calculadoracalorias2.service.PlatoServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    private IPlatoService platoService = new PlatoServiceImp();

    @GetMapping("/{nombre}")
    public ResponseEntity<PlatoDto> findOne(@PathVariable String nombre){

        return new ResponseEntity<>(platoService.findeOne(nombre), HttpStatus.OK);
    }
}
