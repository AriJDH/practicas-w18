package com.example.consultashql.controller;

import com.example.consultashql.dto.Request.MovieDtoReq;
import com.example.consultashql.service.Impl.ActorMovieServiceImpl;
import com.example.consultashql.service.Impl.ActorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActorController {

    private ActorServiceImpl actorService;
    private ActorMovieServiceImpl actorMovieService;

    public ActorController(ActorServiceImpl actorService, ActorMovieServiceImpl actorMovieService) {
        this.actorService = actorService;
        this.actorMovieService = actorMovieService;
    }

    @GetMapping("/actor/getAllWithFavoriteMovieOp1")
    public ResponseEntity<?> getAllWithFavoriteMovie1(){
        return new ResponseEntity(actorService.obtenerActoresConPeliculaFavorita1(), HttpStatus.OK);
    }

    @GetMapping("/actor/getAllWithFavoriteMovieOp2")
    public ResponseEntity<?> getAllWithFavoriteMovie2(){
        return new ResponseEntity(actorService.obtenerActoresConPeliculaFavorita2(), HttpStatus.OK);
    }

    @GetMapping("/actor/getAllToFavoriteMovie/{id}")
    public ResponseEntity<?> getAllToFavoriteMovie(@PathVariable Integer id){
        return new ResponseEntity(actorService.obtenerActoresPorPeliculaFavortita(id), HttpStatus.OK);
    }

    @GetMapping("/actor/getAllWithRatingGreater/{id}")
    public ResponseEntity<?> getAllWithRatingGreater(@PathVariable Integer id){
        return new ResponseEntity(actorService.obtenerActoresPorRatingMayorA(id), HttpStatus.OK);
    }

    @PostMapping("/actor/getAllWithMovie")
    public ResponseEntity<?> getAllWithMovie(@RequestBody MovieDtoReq movie){
        return new ResponseEntity(actorMovieService.obtenerActoresPorPelicula(movie), HttpStatus.OK);
    }

}
