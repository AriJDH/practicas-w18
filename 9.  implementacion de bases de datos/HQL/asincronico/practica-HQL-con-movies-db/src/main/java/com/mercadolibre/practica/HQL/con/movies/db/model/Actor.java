package com.mercadolibre.practica.HQL.con.movies.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //cuando creamos una pelicula harcodeamos la fecha, lo mismo cuando la actualizamos
    /*@Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;*/
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;

    @ManyToMany
    @JoinTable(
            name ="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private Set<Movie> movie;

    @ManyToMany
    @JoinTable(
            name ="actor_episode",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="episode_id")
    )
    private Set<Episode> episode;

}
