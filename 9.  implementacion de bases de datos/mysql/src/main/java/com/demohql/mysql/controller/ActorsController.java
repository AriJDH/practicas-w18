package com.demohql.mysql.controller;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.service.IActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/actors")
public class ActorsController {

    private final IActorService service;

    @GetMapping("/list")
    public List<ActorDTO> getActors(){
        return service.getAllActors();
    }

    @GetMapping("/list/withmovie")
    public List<ActorDTO> getActorsWithMovie(){
        return service.getAllActorsWithMovie();
    }

    @GetMapping("/list/rating")
    public List<ActorDTO> getActorsByRating(@RequestParam Double rating){
        return service.getAllActorsByRating(rating);
    }

}
