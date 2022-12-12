package com.mercadolibre.practica.HQL.con.movies.db.service;

import com.mercadolibre.practica.HQL.con.movies.db.model.Actor;
import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.response.ActorMovieDTOResponse;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iActorRepository;
import com.mercadolibre.practica.HQL.con.movies.db.repository.iMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements iActorService{

    @Autowired
    iActorRepository actorRepository;
    @Autowired
    iMovieRepository movieRepository;
    @Autowired
    iMovieService movieService;


    @Autowired
    ModelMapper mapper;



    public List<ActorDTO> getAllActors() {
        List<Actor> actors = actorRepository.findAllActors();

        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> findActorsWithRatingGraterThan(Double rating) {
        List<Actor> actors = actorRepository.findActorsByRatingGreaterThan(rating);
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorDTO> findActorsByMovie(String title) {
        List<Actor> actors = actorRepository.findActorsByMovie(title) ;
        return actors.stream().map(actor -> mapper.map(actor, ActorDTO.class)).collect(Collectors.toList());
    }


    @Override
    public List<ActorMovieDTOResponse> actorsWithFavoriteMovie() {
        List<ActorMovieDTOResponse> response = new ArrayList<>();
        ActorMovieDTOResponse actorMovieDTOResponse = new ActorMovieDTOResponse();

        List<ActorDTO> actorsList = this.getAllActors();

        for (ActorDTO a:actorsList) {

            if (a.getFavoriteMovieId() != null) {
                System.out.println(a);
                MovieDTO m = movieService.findMovieById(a.getFavoriteMovieId());
                System.out.println(m);
                actorMovieDTOResponse.setActor(a);
                System.out.println(actorMovieDTOResponse.getActor());
                actorMovieDTOResponse.setMovie(m);
                System.out.println(actorMovieDTOResponse.getMovie());

            }
            System.out.println(actorMovieDTOResponse);
            response.add(actorMovieDTOResponse);
        }

        System.out.println(response);
        return response;
    }
}
