package com.example.moviehql.repository;

import com.example.moviehql.entity.Actor;
import com.example.moviehql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryActor extends JpaRepository<Actor,Integer> {
    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("FROM Actor a WHERE a.firstName LIKE :firstName")
    Actor findByName(@Param("firstName") String firstName);

    @Query("FROM Actor a WHERE a.firstName LIKE :firstName")
    List<Actor> findAllActorsByName(@Param("firstName") String firstName);

    @Query("FROM Movie m WHERE m.id = :favoriteMovieId")
    Movie findMovieOfActor(@Param("favoriteMovieId") Integer favoriteMovieId);
}
