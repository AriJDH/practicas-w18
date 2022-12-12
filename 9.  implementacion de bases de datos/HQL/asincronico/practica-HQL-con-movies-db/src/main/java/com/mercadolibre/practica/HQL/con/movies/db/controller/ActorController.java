package com.mercadolibre.practica.HQL.con.movies.db.controller;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.response.ActorMovieDTOResponse;
import com.mercadolibre.practica.HQL.con.movies.db.service.ActorService;
import com.mercadolibre.practica.HQL.con.movies.db.service.iActorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    @Autowired
    iActorService actorService;


    @GetMapping("/actors/withFavMovie")
    public ResponseEntity<List<ActorMovieDTOResponse>> listActorsWithFavoriteMovie(){

        return ResponseEntity.ok(actorService.actorsWithFavoriteMovie());
    }

    @GetMapping("/actors/all")
    public ResponseEntity<List<ActorDTO>> getAllActors(){
        return ResponseEntity.ok(actorService.getAllActors());
    }


    @GetMapping("/actors/filterByRating/{rating}")
    public ResponseEntity<List<ActorDTO>> getAllActorsByRating(@PathVariable Double rating){
        return ResponseEntity.ok(actorService.findActorsWithRatingGraterThan(rating));
    }

    @GetMapping("/actors/filterByMovie/{title}")
    public ResponseEntity<List<ActorDTO>> getAllActorByMovie(@PathVariable String title){
        return ResponseEntity.ok(actorService.findActorsByMovie(title));
    }
}
