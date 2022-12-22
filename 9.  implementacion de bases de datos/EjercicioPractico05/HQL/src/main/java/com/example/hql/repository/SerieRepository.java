package com.example.hql.repository;

import com.example.hql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT DISTINCT s.serie.title " +
            "FROM Season s " +
            "WHERE s.number > :numberOfSeasons ")
    List<String[]> getAllSeriesWithSeasonGreaterThan(@Param("numberOfSeasons") Integer numberOfSeasons);

}
