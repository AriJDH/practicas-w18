package com.mercadolibre.practica.HQL.con.movies.db.repository;

import com.mercadolibre.practica.HQL.con.movies.db.model.Episode;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.EpisodeDTO;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface iEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query(value = "SELECT *  FROM episodes e JOIN actor_episode ae ON e.id= ae.episode_id JOIN actors a ON ae.actor_id= a.id WHERE a.first_name like :actorName",
    nativeQuery = true)
    List<Episode> findEpisodesByActor(String actorName);


}
