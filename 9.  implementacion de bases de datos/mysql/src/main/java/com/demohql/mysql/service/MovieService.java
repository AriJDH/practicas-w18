package com.demohql.mysql.service;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.entities.dto.ActorMovieResponseDTO;
import com.demohql.mysql.entities.dto.MovieDTO;
import com.demohql.mysql.entities.entity.Actor;
import com.demohql.mysql.entities.entity.Movie;
import com.demohql.mysql.entities.entity.MovieActor;
import com.demohql.mysql.repository.IActorRepository;
import com.demohql.mysql.repository.IMovieActorRepository;
import com.demohql.mysql.repository.IMovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    IMovieActorRepository movieActorRepository;

    @Autowired
    IActorRepository actorRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ActorMovieResponseDTO getMovieByName(String movieName) {

        ActorMovieResponseDTO actorMovieResponseDTO = new ActorMovieResponseDTO();
        List<Integer> ids = new ArrayList<>();

        MovieDTO movieDTO = mapper.convertValue(movieRepository.findMovieByName(movieName),MovieDTO.class);
        List<MovieActor> movieActors = movieActorRepository.findAllIdActorsByMovieId(movieDTO.getId());
        ids.addAll(movieActors.stream().map(ma -> ma.getActorId()).collect(Collectors.toList()));
        List<Actor> actorsList = actorRepository.findAllActorsById(ids);
        List<ActorDTO> actorDTOList = actorsList.stream().map(actor -> mapper.convertValue(actor, ActorDTO.class)).collect(Collectors.toList());


        actorMovieResponseDTO.setMovie(movieDTO);
        actorMovieResponseDTO.setActors(actorDTOList);

        return actorMovieResponseDTO;
    }
}
