package com.example.consultashql.service;

import com.example.consultashql.dto.Request.MovieDtoReq;
import com.example.consultashql.dto.Response.ActorDtoResp;
import com.example.consultashql.entity.Actor;
import com.example.consultashql.entity.ActorMovie;
import com.example.consultashql.entity.Movie;

import java.util.List;

public interface IActorMovieService {

    public List<ActorDtoResp>obtenerActoresPorPelicula(MovieDtoReq movie);
    public List<MovieDtoReq>obtenerPeliculasPorRatingActor(Integer rating);

}
