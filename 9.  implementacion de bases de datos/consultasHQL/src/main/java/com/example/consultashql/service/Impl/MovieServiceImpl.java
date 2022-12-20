package com.example.consultashql.service.Impl;

import com.example.consultashql.dto.Request.GenreDtoReq;
import com.example.consultashql.dto.Response.MovieDtoResp;
import com.example.consultashql.entity.Genre;
import com.example.consultashql.entity.Movie;
import com.example.consultashql.repository.IMovieRepository;
import com.example.consultashql.service.IMovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements IMovieService {
    private IMovieRepository movieRepository;
    private ModelMapper mapper = new ModelMapper();

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDtoResp> getMoviesByGenre(GenreDtoReq genre) {
        ModelMapper mapper = new ModelMapper();
        Genre genreEntity = mapper.map(genre, Genre.class);
        List<Movie> moviesEntity = movieRepository.findMoviesByGenre(genreEntity);
        return moviesEntity.stream().map(m -> mapper.map(m, MovieDtoResp.class)).collect(Collectors.toList());
    }
}
