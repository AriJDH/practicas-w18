package com.example.moviehql.service;

import com.example.moviehql.dto.ActorDto;
import com.example.moviehql.dto.ActorMovieDto;
import com.example.moviehql.dto.MovieDto;

import java.util.List;

public interface IActorService {
    List<ActorDto> getAllActors();

    ActorDto getActorByName(String name);
    List<ActorDto> getAllActorByName(String name);

    ActorMovieDto getActorWithFavoriteMovie(String actorName);

    MovieDto getMovieOfActor(Integer favoriteMovieId);
}
