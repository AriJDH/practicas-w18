package com.mercadolibre.practica.HQL.con.movies.db.controller;

import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.service.iMovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    iMovieService movieService;

    @GetMapping("/movies/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @GetMapping("/movies/filterByRating/{rating}")
    public ResponseEntity<List<MovieDTO>> findMoviesFilteredByRating(@PathVariable Double rating){
        return ResponseEntity.ok(movieService.findeMoviesWithRatingGraterThan(rating));
    }

    @GetMapping("/movies/filterByActorsRating/{rating}")
    public ResponseEntity<List<MovieDTO>> findMoviesFilteredByActorsRating(@PathVariable Double rating){
        return ResponseEntity.ok(movieService.findMoviesByActorsRating(rating));
    }

    @GetMapping("/movies/filterByGenre/{genre}")
    public ResponseEntity<List<MovieDTO>> findMoviesByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.findMoviesByGenre(genre));
    }
}
