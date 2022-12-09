package com.example.movies_hql.repository;

import com.example.movies_hql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("SELECT ae FROM ActorEpisode ae WHERE ae.actor.firstName = :nombreActor")
   List<Episode> consultarEpisodioPorActor(@Param("nombreActor") String nombreActor);
}
