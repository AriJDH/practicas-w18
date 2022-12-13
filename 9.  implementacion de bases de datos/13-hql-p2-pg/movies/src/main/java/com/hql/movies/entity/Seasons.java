package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
public class Seasons {
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
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
    @Basic
    @Column(name = "release_date", nullable = false)
    private Timestamp releaseDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;
//    @Basic
//    @Column(name = "serie_id", nullable = true)
//    private Long serieId;
    @OneToMany(mappedBy = "seasonsBySeasonId")
    private Collection<Episodes> episodesById;
    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Series seriesBySerieId;

}
