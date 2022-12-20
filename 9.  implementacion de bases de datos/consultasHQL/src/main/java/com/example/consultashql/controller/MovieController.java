package com.example.consultashql.controller;

import com.example.consultashql.dto.Request.GenreDtoReq;
import com.example.consultashql.entity.Genre;
import com.example.consultashql.service.Impl.ActorMovieServiceImpl;
import com.example.consultashql.service.Impl.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    private MovieServiceImpl movieService;
    private ActorMovieServiceImpl actorMovieService;

    public MovieController(MovieServiceImpl movieService, ActorMovieServiceImpl actorMovieService) {
        this.movieService = movieService;
        this.actorMovieService = actorMovieService;
    }

    @GetMapping("getMoviesByRatingActor")
    public ResponseEntity<?> getMoviesByRatingActor(@RequestParam Integer rating){
        return new ResponseEntity(actorMovieService.obtenerPeliculasPorRatingActor(rating), HttpStatus.OK);
    }

    @PostMapping("getMoviesByGenre")
    public ResponseEntity<?> getMoviesByRatingActor(@RequestBody GenreDtoReq genre){
        return new ResponseEntity(movieService.getMoviesByGenre(genre), HttpStatus.OK);
    }

}
