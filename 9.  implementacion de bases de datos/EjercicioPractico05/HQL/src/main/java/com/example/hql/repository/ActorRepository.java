package com.example.hql.repository;

import com.example.hql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a.firstName, a.lastName, a.movie.id " +
            "FROM Actor a " +
            "WHERE a.movie.id <> 0 ")
    List<String[]> getAllActorWithFavoriteMovie();

    @Query("SELECT a.firstName, a.lastName, a.rating " +
            "FROM Actor a " +
            "WHERE a.rating > :actorRating ")
    List<String[]> getAllActorWithRaitingGreaterThan(@Param("actorRating") Double actorRating);

    @Query("SELECT am.actor.firstName, am.actor.lastName, am.movie.title " +
            "FROM ActorMovie am " +
            "WHERE am.movie.title = :movieTitle ")
    List<String[]> getAllActorInMovieEqualsTo(@Param("movieTitle") String movieTitle);

}
