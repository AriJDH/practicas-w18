package com.mercadolibre.movies.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="actors")
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String firstName;
    private String lastName;
    private Double rating;
    @OneToOne
    @JoinColumn(name="favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;
}
