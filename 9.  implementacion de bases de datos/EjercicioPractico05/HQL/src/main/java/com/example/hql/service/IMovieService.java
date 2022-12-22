package com.example.hql.service;

import java.util.List;

public interface IMovieService {

    List<String[]> getAllMovieWithActorsRatingGreaterThan(Double rating);

    List<String[]> getAllMovieWithGenreEqualsTo(String genreName);
}
