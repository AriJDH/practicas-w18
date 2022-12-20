package com.example.consultashql.service;

import com.example.consultashql.dto.Response.ActorDtoResp;
import com.example.consultashql.entity.Actor;

import java.util.List;

public interface IActorService {
    public List<ActorDtoResp> obtenerActoresConPeliculaFavorita1();
    public List<ActorDtoResp> obtenerActoresConPeliculaFavorita2();
    public List<ActorDtoResp> obtenerActoresPorPeliculaFavortita(Integer id);
    public List<ActorDtoResp>obtenerActoresPorRatingMayorA(Integer id);
}
