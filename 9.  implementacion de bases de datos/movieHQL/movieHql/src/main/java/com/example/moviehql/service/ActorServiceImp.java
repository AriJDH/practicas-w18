package com.example.moviehql.service;

import com.example.moviehql.entity.Movie;
import com.example.moviehql.dto.ActorDto;
import com.example.moviehql.entity.Actor;
import com.example.moviehql.dto.ActorMovieDto;
import com.example.moviehql.dto.MovieDto;
import com.example.moviehql.repository.IRepositoryActor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImp implements IActorService {

    @Autowired
    IRepositoryActor iRepositoryActor;
    @Autowired
    ModelMapper mapper;

    public List<ActorDto> getAllActors() {
        List<Actor> actors = iRepositoryActor.findAllActors();

        return actors.stream().map(actor -> mapper.map(actor, ActorDto.class)).collect(Collectors.toList());
    }

    @Override
    public ActorDto getActorByName(String name) {
        Actor actor = iRepositoryActor.findByName(name);
        return mapper.map(actor, ActorDto.class);
    }

    @Override
    public List<ActorDto> getAllActorByName(String name) {
        List<Actor> actors = iRepositoryActor.findAllActorsByName(name);
        return actors.stream().map(act -> mapper.map(act, ActorDto.class)).collect(Collectors.toList());
    }

    @Override
    public ActorMovieDto getActorWithFavoriteMovie(String actorName) {
        ActorMovieDto actorMovieDto = new ActorMovieDto();
        ActorDto actorDto = getActorByName(actorName);
        MovieDto movieDto = getMovieOfActor(actorDto.getFavoriteMovieId());
        actorMovieDto.setActor(actorDto);
        actorMovieDto.setFavoriteMovie(movieDto);
        return actorMovieDto;
    }

    @Override
    public MovieDto getMovieOfActor(Integer id) {
        Movie movie = iRepositoryActor.findMovieOfActor(id);
        return mapper.map(movie, MovieDto.class);
    }


}
