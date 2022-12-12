package com.mercadolibre.practica.HQL.con.movies.db.repository;

import com.mercadolibre.practica.HQL.con.movies.db.model.Actor;
import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iMovieRepository extends JpaRepository<Movie, Integer> {
    @Query("FROM Movie")
    List<Movie> findAllMovies();

    @Query("FROM Movie M WHERE M.id = :id")
    Movie findMovieById(Integer id);

    @Query("FROM Movie m WHERE m.rating > :rating")
    List<Movie> findMoviesByRatingGreaterThan(Double rating);

    @Query(value = "SELECT * FROM movies m JOIN actor_movie am ON m.id = am.movie_id JOIN actors a ON am.actor_id = a.id WHERE a.rating > :rating",
            nativeQuery = true)
    List<Movie> findMoviesByActorsRating(Double rating);

    @Query(value = "SELECT * FROM movies m JOIN genres g on m.genre_id=g.id WHERE g.name LIKE :genreName",
    nativeQuery = true)
    List<Movie> findMoviesByGenre(String genreName);


}
