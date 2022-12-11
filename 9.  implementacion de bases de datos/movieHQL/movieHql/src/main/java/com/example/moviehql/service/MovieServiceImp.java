package com.example.moviehql.service;

import com.example.moviehql.dto.MovieDto;
import com.example.moviehql.entity.Movie;
import com.example.moviehql.repository.IRepositoryMovie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImp implements IMovieService{
    @Autowired
    IRepositoryMovie repositoryMovie;

    @Autowired
    ModelMapper mapper;
    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = repositoryMovie.getAllMovies();
        return movies.stream().map(m -> mapper.map(m, MovieDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getAllMoviesByTLike(String titleLike) {
        List<Movie> movies = repositoryMovie.findAllMoviesByTitleLike(titleLike);
        return movies.stream().map(m -> mapper.map(m, MovieDto.class)).collect(Collectors.toList());
    }
}
