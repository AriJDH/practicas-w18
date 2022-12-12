package com.mercadolibre.practica.HQL.con.movies.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
    @Setter
    @Table(name = "seasons")
@Entity
    public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Serie serie;
}
