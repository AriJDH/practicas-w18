package com.example.hql.service;

import com.example.hql.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService{

    private final MovieRepository movieRepository;


    @Override
    public List<String[]> getAllMovieWithActorsRatingGreaterThan(Double actorRating) {

        return movieRepository.getAllMovieWithActorsRatingGreaterThan(actorRating);
    }

    @Override
    public List<String[]> getAllMovieWithGenreEqualsTo(String genreName) {

        return movieRepository.getAllMovieWithGenreEqualsTo(genreName);
    }

}
