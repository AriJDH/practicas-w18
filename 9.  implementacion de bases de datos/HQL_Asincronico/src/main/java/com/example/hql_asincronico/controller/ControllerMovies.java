package com.example.hql_asincronico.controller;

import com.example.hql_asincronico.dto.response.ActorsDTOResponse;
import com.example.hql_asincronico.entity.Actor;
import com.example.hql_asincronico.service.IServiceActor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerMovies {
    private final IServiceActor iServiceActor;
    public ControllerMovies(IServiceActor iServiceActor){
        this.iServiceActor = iServiceActor;
    }

    @GetMapping("Actors/FavoriteMovies")
    public ResponseEntity<List<Actor>> findByFavoriteMovieNotNull(){
        return new ResponseEntity<>(iServiceActor.findByFavoriteMovieNotNull(), HttpStatus.OK);
    }
}
