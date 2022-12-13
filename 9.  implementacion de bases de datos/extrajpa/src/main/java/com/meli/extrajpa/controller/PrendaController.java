package com.meli.extrajpa.controller;

import com.meli.extrajpa.dto.PrendaDtoReq;
import com.meli.extrajpa.dto.PrendaDtoRes;
import com.meli.extrajpa.service.IPrendaService;
import com.meli.extrajpa.service.PrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    private IPrendaService prendaService;

    public PrendaController(PrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping
    public ResponseEntity<PrendaDtoRes> addPrenda(@RequestBody PrendaDtoReq prendaDtoReq) {
        return new ResponseEntity<>(prendaService.addClothes(prendaDtoReq), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrendaDtoRes>> getAllClothes() {
        return new ResponseEntity<>(prendaService.getAllClothes(), HttpStatus.OK);
    }
}
