package com.example.hql_asincronico.service;

import com.example.hql_asincronico.dto.response.ActorsDTOResponse;
import com.example.hql_asincronico.entity.Actor;

import java.util.List;

public interface IServiceActor {
     List<Actor> findByFavoriteMovieNotNull();
}
