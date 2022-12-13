package com.hql.movies.controller;

import com.hql.movies.service.IActorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorsController {
    private final IActorsService actorsService;

    public ActorsController(IActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getActorsWithFavouriteMovie() {
        return new ResponseEntity<>(actorsService.getActorsWithFavouriteMovie(), HttpStatus.OK);
    }
}
