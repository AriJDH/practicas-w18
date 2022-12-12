package com.mercadolibre.practica.HQL.con.movies.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "episodes")
@Getter @Setter
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*@Column(name = "created_at")
    private LocalDate createdAat;
    @Column(name = "updated_at")
    private LocalDate updatedAt;*/
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Season season;

}
