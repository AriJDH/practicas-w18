package com.demohql.mysql.repository;

import com.demohql.mysql.entities.entity.Actor;
import com.demohql.mysql.entities.entity.Movie;
import com.demohql.mysql.entities.entity.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieActorRepository extends JpaRepository<MovieActor, Integer> {

    @Query("From MovieActor MA WHERE MA.movieId = :movieId")
    List<MovieActor> findAllIdActorsByMovieId(@Param("movieId") Integer movieId);

}
