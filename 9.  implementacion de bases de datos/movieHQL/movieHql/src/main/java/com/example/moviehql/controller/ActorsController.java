package com.example.moviehql.controller;

import com.example.moviehql.dto.ActorDto;
import com.example.moviehql.dto.ActorMovieDto;
import com.example.moviehql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorsController {
    @Autowired
    IActorService service;

    //Liste todos los actores de la bd
    @GetMapping("/actors")
    public List<ActorDto> getActors(){
        return service.getAllActors();
    }

    //Devolver un actor segun el nombre pasado por parametro, TIRA ERROR: cuando hay más de un actor con el nombre pasado
    @GetMapping("/actorbyname")
    public ActorDto getActorByName(@RequestParam String name){
        return service.getActorByName(name);
    }

    @GetMapping("/actorsbyname")
    public List<ActorDto> getAllActorByName(@RequestParam String name){
        return service.getAllActorByName(name);
    }

    //Devuelve la pelicula favorita del actor pasado por parametro TIRA ERROR: cuando hay más de un actor con el nombre pasado
    @GetMapping("/actormovie")
    public ActorMovieDto getActorWithFavoriteMovie(String actorName){
        return service.getActorWithFavoriteMovie(actorName);
    }
}
