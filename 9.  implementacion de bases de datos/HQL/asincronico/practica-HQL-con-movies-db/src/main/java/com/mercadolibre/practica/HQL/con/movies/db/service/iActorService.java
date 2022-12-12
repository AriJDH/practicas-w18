package com.mercadolibre.practica.HQL.con.movies.db.service;


import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.response.ActorMovieDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface iActorService {
    List<ActorMovieDTOResponse> actorsWithFavoriteMovie();

    List<ActorDTO> getAllActors();

    List<ActorDTO> findActorsWithRatingGraterThan(Double rating);

    List<ActorDTO> findActorsByMovie(String title);

}
