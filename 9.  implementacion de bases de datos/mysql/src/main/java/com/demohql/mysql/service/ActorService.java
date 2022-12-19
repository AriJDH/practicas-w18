package com.demohql.mysql.service;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.entities.dto.ActorMovieResponseDTO;
import com.demohql.mysql.entities.dto.MovieDTO;
import com.demohql.mysql.entities.entity.Actor;
import com.demohql.mysql.repository.IActorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActorService implements IActorService {

    @Autowired
    IActorRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = repository.findAllActors();
        return actors.stream().map(actor -> mapper.convertValue(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAllActorsWithMovie() {
        List<Actor> actors = repository.findAllActorsWithMovie();
        return actors.stream().map(actor -> mapper.convertValue(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> getAllActorsByRating(Double rating) {
        List<Actor> actors = repository.findAllActorsByRating(rating);
        return actors.stream().map(actor -> mapper.convertValue(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ActorDTO getActorByName(String name) {
        return null;
    }

    @Override
    public MovieDTO getMovieOfActor(Integer id) {
        return null;
    }

    @Override
    public ActorMovieResponseDTO getActorWithfavoriteMovie(String name) {
        return null;
    }
}
