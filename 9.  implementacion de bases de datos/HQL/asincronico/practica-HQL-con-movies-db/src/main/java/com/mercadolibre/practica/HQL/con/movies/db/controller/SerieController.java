package com.mercadolibre.practica.HQL.con.movies.db.controller;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.SerieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.service.iSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {
    @Autowired
    iSerieService serieService;

    @GetMapping("/series/filterBySeasons/{quantity}")
    public ResponseEntity<List<SerieDTO>> getAllSeriesByQuantityOfSeasons(@PathVariable Integer quantity){
        return ResponseEntity.ok(serieService.findSeriesByQuantityOfSeasons(quantity));
    }
}
