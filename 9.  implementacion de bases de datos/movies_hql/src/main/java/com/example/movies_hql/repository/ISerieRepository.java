package com.example.movies_hql.repository;

import com.example.movies_hql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("SELECT s.serie FROM Season s WHERE s.number > :cantidadTemp")
    List<Serie> consultarSeriesPorCantidadTemp(@Param("cantidadTemp") Integer cantidadTemp);
}
