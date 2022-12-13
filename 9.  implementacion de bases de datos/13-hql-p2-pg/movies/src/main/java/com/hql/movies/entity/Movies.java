package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Movies {
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
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Basic
    @Column(name = "rating", nullable = false, precision = 1)
    private BigDecimal rating;
    @Basic
    @Column(name = "awards", nullable = false)
    private Integer awards;
    @Basic
    @Column(name = "release_date", nullable = false)
    private Timestamp releaseDate;
    @Basic
    @Column(name = "length", nullable = true)
    private Integer length;
//    @Basic
//    @Column(name = "genre_id", nullable = true)
//    private Long genreId;
    @OneToMany(mappedBy = "moviesByMovieId", cascade = CascadeType.ALL)
    private Collection<ActorMovie> actorMoviesById;
    @OneToMany(mappedBy = "moviesByFavoriteMovieId", cascade = CascadeType.ALL)
    private Collection<Actors> actorsById;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genres genresByGenreId;

}
