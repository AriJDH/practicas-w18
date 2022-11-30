package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {

    IObtenerDiplomaService service;

    ObtenerDiplomaController(ObtenerDiplomaService service){
        this.service = service;
    }

    @GetMapping("/analyzeScores/{studentId}")
    public StudentDTO analyzeScores(@PathVariable Long studentId) {
        return service.analyzeScores(studentId);
    }
}