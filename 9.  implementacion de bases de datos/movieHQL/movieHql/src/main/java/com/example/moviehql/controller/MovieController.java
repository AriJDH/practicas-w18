package com.example.moviehql.controller;

import com.example.moviehql.dto.MovieDto;
import com.example.moviehql.entity.Movie;
import com.example.moviehql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    IMovieService service;

    // Listar todas las peliculas
    @GetMapping("/movies")
    public List<MovieDto> getAllMovies() {
        return service.getAllMovies();
    }
    //listar las peliculas que contengan el nombre pasado por parametro
    @GetMapping("/moviesName")
    public List<MovieDto> getAllMoviesByTLike(@RequestParam String titleLike) {
        return service.getAllMoviesByTLike(titleLike);
    }
    //Listar las peliculas que tengan el rating mayot o igual al pasado por parametro

    //listas las peliculas que tengan mayor cantidad de premios al pasado por parametro
}
