package com.example.hql.service;

import java.util.List;

public interface IActorService {

    List<String[]> getAllActorWithFavoriteMovie();

    List<String[]> getAllActorWithRaitingGreaterThan(Double rating);

    List<String[]> getAllActorInMovieEqualsTo(String title);

}
