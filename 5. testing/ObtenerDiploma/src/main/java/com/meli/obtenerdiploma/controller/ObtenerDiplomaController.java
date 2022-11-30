package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {

    IObtenerDiplomaService service;

    public ObtenerDiplomaController(ObtenerDiplomaService service) {
        this.service = service;
    }

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return service.analyzeScores(rq);
    }
}
