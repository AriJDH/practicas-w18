package com.example.hql.controller;

import com.example.hql.service.IActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
@AllArgsConstructor
public class ActorController {

    private final IActorService actorService;


    @GetMapping("/query1")
    public ResponseEntity<?> getQuery1(){

        return new ResponseEntity<>(actorService.getAllActorWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/query2")
    public ResponseEntity<?> getQuery2(@RequestParam(name = "actor_rating") Double actorRating){

        return new ResponseEntity<>(actorService.getAllActorWithRaitingGreaterThan(actorRating), HttpStatus.OK);
    }

    @GetMapping("/query3")
    public ResponseEntity<?> getQuery3(@RequestParam(name = "movie_title") String movieTitle){

        return new ResponseEntity<>(actorService.getAllActorInMovieEqualsTo(movieTitle), HttpStatus.OK);
    }

}
