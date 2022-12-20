package com.example.consultashql.repository;

import com.example.consultashql.entity.Actor;
import com.example.consultashql.entity.ActorMovie;
import com.example.consultashql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorMovieRepository extends JpaRepository<ActorMovie, Integer> {
    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("select a.actor from ActorMovie a where a.movie = :movie ")
    List<Actor> listarActoresPorPelicula(@Param("movie") Movie movie);

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("select a.movie from ActorMovie a where a.actor.rating > :rating")
    List<Movie> listarPeliculasPorActorConRatingMayorA(@Param("rating") Integer rating);

}
