package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements iMovieService{
    @Autowired
    iMovieRepository movieRepository;
    @Autowired
    ModelMapper mapper;


    @Override
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAllMovies();

        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());
    }

    public MovieDTO findMovieById(Integer id) {
        Movie m = movieRepository.findMovieById(id);
        return mapper.map(m, MovieDTO.class);
    }

    public List<MovieDTO> findeMoviesWithRatingGraterThan(Double rating){
        List<Movie> movies = movieRepository.findMoviesByRatingGreaterThan(rating);
        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());


    }

    @Override
    public List<MovieDTO> findMoviesByActorsRating(Double rating) {
        List<Movie> movies = movieRepository.findMoviesByActorsRating(rating);
        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());

    }

    @Override
    public List<MovieDTO> findMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findMoviesByGenre(genre);
        return movies.stream().map(movie -> mapper.map(movie, MovieDTO.class)).collect(Collectors.toList());

    }
}
