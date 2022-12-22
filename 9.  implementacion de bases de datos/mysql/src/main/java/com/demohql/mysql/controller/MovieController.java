package com.demohql.mysql.controller;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.entities.dto.ActorMovieResponseDTO;
import com.demohql.mysql.service.IActorService;
import com.demohql.mysql.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService movieService;

    @GetMapping("/list/actors")
    public ResponseEntity<ActorMovieResponseDTO> getActorsByMovieName(@RequestParam String movie){
        return new ResponseEntity<>(movieService.getMovieByName(movie), HttpStatus.OK);
    }

}
