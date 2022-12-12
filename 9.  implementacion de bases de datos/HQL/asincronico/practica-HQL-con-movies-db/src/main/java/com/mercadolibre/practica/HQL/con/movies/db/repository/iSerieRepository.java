package com.mercadolibre.practica.HQL.con.movies.db.repository;

import com.mercadolibre.practica.HQL.con.movies.db.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iSerieRepository extends JpaRepository<Serie, Integer> {

    @Query(value = "SELECT * FROM series INNER JOIN seasons on series.id = seasons.serie_id where seasons.number =:quantity",
    nativeQuery = true)
    List<Serie> findAllByQuantityOfSeasons(Integer quantity);
}
