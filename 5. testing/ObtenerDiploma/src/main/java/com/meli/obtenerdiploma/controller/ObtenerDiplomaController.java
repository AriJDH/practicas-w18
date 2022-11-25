package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDto;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class ObtenerDiplomaController {

    private IObtenerDiplomaService service;

    public ObtenerDiplomaController(ObtenerDiplomaService service) {
        this.service = service;
    }

    @PostMapping("/analyzeScores")
    public StudentDto analyzeScores(
            @Valid @RequestBody StudentDto rq) {

        return service.analyzeScores(rq);
    }
}
