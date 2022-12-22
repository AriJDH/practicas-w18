package com.demohql.mysql.service;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.entities.dto.ActorMovieResponseDTO;
import com.demohql.mysql.entities.dto.MovieDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> getAllActors();

    List<ActorDTO> getAllActorsWithMovie();

    List<ActorDTO> getAllActorsByRating(Double rating);

    List<ActorDTO> getAllActorsById(List<Integer> actorsIds);

   }
