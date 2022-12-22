package com.example.hql.repository;

import com.example.hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT am.movie.title, am.actor.firstName, am.actor.lastName, am.actor.rating " +
            "FROM ActorMovie am " +
            "WHERE am.actor.rating > :actorRating")
    List<String[]> getAllMovieWithActorsRatingGreaterThan(@Param("actorRating") Double actorRating);

    @Query("SELECT m.title, m.genre.name " +
            "FROM Movie m " +
            "WHERE m.genre.name = :genreName")
    List<String[]> getAllMovieWithGenreEqualsTo(@Param("genreName") String genreName);

}
