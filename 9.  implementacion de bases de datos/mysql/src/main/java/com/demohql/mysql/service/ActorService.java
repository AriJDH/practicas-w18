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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public List<ActorDTO> getAllActorsById(List<Integer> actorsIds) {
        List<Actor> actors = repository.findAllActorsById(actorsIds);
        return actors.stream().map(actor -> mapper.convertValue(actor, ActorDTO.class)).collect(Collectors.toList());
    }


}
