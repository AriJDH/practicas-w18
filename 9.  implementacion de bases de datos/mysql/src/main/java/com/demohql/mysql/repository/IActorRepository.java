package com.demohql.mysql.repository;

import com.demohql.mysql.entities.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("From Actor A WHERE A.favoriteMovieId Is Not null")
    List<Actor> findAllActorsWithMovie();

    @Query("From Actor A WHERE A.rating > :rating")
    List<Actor> findAllActorsByRating(@Param("rating") Double rating);

}
