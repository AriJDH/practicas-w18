package com.example.hql.repository;

import com.example.hql.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("SELECT ae.episode.season.serie.title, ae.episode.title, ae.actor.firstName, ae.actor.lastName " +
            "FROM ActorEpisode ae " +
            "WHERE ae.actor.firstName = :actorFirstName AND ae.actor.lastName = :actorLastName")
    List<String[]> getAllEpisodeWithActorEqualsTo(@Param("actorFirstName") String actorFirstName,
                                                  @Param("actorLastName") String actorLastName);

}
