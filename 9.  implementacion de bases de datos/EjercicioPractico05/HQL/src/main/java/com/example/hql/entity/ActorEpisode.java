package com.example.hql.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {

    @Id
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "episode_id", nullable = false)
    private Episode episode;

}
