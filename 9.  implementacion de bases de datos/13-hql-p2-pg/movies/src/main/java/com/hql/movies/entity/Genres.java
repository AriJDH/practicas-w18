package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Genres {
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
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "ranking", nullable = false)
    private Integer ranking;
    @Basic
    @Column(name = "active", nullable = false)
    private byte active;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<Movies> moviesById;
    @OneToMany(mappedBy = "genresByGenreId")
    private Collection<Series> seriesById;

}
