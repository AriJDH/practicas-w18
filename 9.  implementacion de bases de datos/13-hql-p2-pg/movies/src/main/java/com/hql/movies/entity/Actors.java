package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Actors {
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
    @Basic
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Basic
    @Column(name = "rating", nullable = true, precision = 1)
    private BigDecimal rating;
//    @Basic
//    @Column(name = "favorite_movie_id", nullable = true)
//    private Long favoriteMovieId;
    @OneToMany(mappedBy = "actorsByActorId")
    private Collection<ActorEpisode> actorEpisodesById;
    @OneToMany(mappedBy = "actorsByActorId")
    private Collection<ActorMovie> actorMoviesById;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movies moviesByFavoriteMovieId;

}
