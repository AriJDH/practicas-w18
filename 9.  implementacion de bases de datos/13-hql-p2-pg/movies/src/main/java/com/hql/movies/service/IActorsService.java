package com.hql.movies.service;

import com.hql.movies.entity.Actors;

import java.util.List;

public interface IActorsService {
    List<Actors> getActorsWithFavouriteMovie();
}
