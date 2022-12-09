package com.example.movies_hql.repository;

import com.example.movies_hql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT am FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> consultarPeliculasActoresRating(@Param("rating") BigDecimal rating);

    @Query("SELECT m FROM Movie m WHERE m.genre.name = :genero")
    List<Movie> consultarPeliculasPorGenero(@Param("genero") String genero);
}
