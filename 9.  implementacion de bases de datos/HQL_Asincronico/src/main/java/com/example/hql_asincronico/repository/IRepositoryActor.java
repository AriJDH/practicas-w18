package com.example.hql_asincronico.repository;

import com.example.hql_asincronico.dto.response.ActorsDTOResponse;
import com.example.hql_asincronico.entity.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryActor extends CrudRepository<Actor, Integer> {
    @Query("from Actor act where act.favorite_movie_id is not null")
    List<Actor> findByFavoriteMovieNotNull();
}
