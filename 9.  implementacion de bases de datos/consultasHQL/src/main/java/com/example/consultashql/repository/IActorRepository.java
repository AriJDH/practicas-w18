package com.example.consultashql.repository;

import com.example.consultashql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    //Listar todos los actores que tengan declarada una película favorita.
    List<Actor>findActorsByFavoriteMovieNotNull();
    @Query("select a from Actor a where a.favoriteMovie.id > 0")
    List<Actor>obtenerActoresConPeliculaFavortita();
    List<Actor>findActorsByFavoriteMovie_Id(Integer id);

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    List<Actor>findActorsByRatingGreaterThan(Integer id);

}
