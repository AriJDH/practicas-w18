package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "actor_episode", schema = "movies_db")
public class ActorEpisode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
//    @Basic
//    @Column(name = "actor_id", nullable = false)
//    private Long actorId;
//    @Basic
//    @Column(name = "episode_id", nullable = false)
//    private Long episodeId;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    private Actors actorsByActorId;
    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "id", nullable = false)
    private Episodes episodesByEpisodeId;

}
