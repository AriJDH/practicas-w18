package com.demohql.mysql.entities.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "actor_movie")
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="actor_id")
    private Integer actorId;

    @Column(name="movie_id")
    private Integer movieId;
}
