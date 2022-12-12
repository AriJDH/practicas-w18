package com.mercadolibre.practica.HQL.con.movies.db.controller;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.EpisodeDTO;
import com.mercadolibre.practica.HQL.con.movies.db.service.iEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodeController {
    @Autowired
    iEpisodeService episodeService;

    @GetMapping("/episodes/filterByActor/{actor}")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesWithActor(@PathVariable String actor){
        return ResponseEntity.ok(episodeService.findEpisodesWithActor(actor));
    }
}
