package com.example.hql.controller;

import com.example.hql.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService movieService;


    @GetMapping("/query4")
    public ResponseEntity<?> getQuery4(@RequestParam(name = "actor_rating") Double actorRating){

        return new ResponseEntity<>(movieService.getAllMovieWithActorsRatingGreaterThan(actorRating), HttpStatus.OK);
    }

    @GetMapping("/query5")
    public ResponseEntity<?> getQuery5(@RequestParam(name = "genre_name") String genreName){

        return new ResponseEntity<>(movieService.getAllMovieWithGenreEqualsTo(genreName), HttpStatus.OK);
    }


}
