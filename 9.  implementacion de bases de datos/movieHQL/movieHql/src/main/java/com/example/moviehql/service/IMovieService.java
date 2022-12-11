package com.example.moviehql.service;

import com.example.moviehql.dto.MovieDto;
import com.example.moviehql.entity.Movie;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getAllMovies();

    List<MovieDto> getAllMoviesByTLike(String titleLike);
}
