package com.mercadolibre.practica.HQL.con.movies.db.repository;

import com.mercadolibre.practica.HQL.con.movies.db.model.Actor;
import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface iActorRepository extends JpaRepository<Actor, Integer> {
    @Query("FROM Actor")
    List<Actor> findAllActors();

    @Query("FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorsByRatingGreaterThan(Double rating);


    @Query(value = "SELECT * FROM actors a JOIN actor_movie am on a.id=am.actor_id JOIN movies m ON am.movie_id = m.id WHERE m.title LIKE :title",
            nativeQuery = true)
    List<Actor> findActorsByMovie(String title);


}
