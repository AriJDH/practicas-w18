package com.example.movies_hql.repository;

import com.example.movies_hql.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT ac FROM Actor ac LEFT JOIN Movie mo ON mo.id = ac.movie.id")
    List<Actor> buscarActoresConPeliculaFavorita();

    @Query("SELECT ac FROM Actor ac WHERE ac.rating > :rating")
    List<Actor> buscarActoresPorRating(@Param("rating") BigDecimal rating);

    @Query("SELECT am.actor FROM ActorMovie am WHERE am.movie.title = :nombrePelicula")
    List<Actor> buscarActoresPorPelicula(@Param("nombrePelicula") String nombrePelicula);

}
