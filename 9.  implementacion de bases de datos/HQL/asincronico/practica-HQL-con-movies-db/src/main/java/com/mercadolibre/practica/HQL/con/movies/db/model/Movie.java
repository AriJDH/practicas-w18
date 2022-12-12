package com.mercadolibre.practica.HQL.con.movies.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
   /* @Column(name = "created_at")
    private LocalDate createdAat;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
*/
    private Integer length;
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Genre genre;
    @ManyToMany(mappedBy = "movie")
    private Set<Actor> actors;
}
