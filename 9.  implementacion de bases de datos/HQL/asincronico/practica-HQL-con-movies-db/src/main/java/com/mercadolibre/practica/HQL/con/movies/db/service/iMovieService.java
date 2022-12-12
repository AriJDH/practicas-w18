package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface iMovieService {
    List<MovieDTO> getAllMovies();


    MovieDTO findMovieById(Integer id);
    List<MovieDTO> findeMoviesWithRatingGraterThan(Double rating);

    List<MovieDTO> findMoviesByActorsRating(Double rating);

    List<MovieDTO> findMoviesByGenre(String genre);

}
