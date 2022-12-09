package com.bootcamp.HQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private String firstName;

    private String lastName;

    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Movie favoriteMovie;

    @ManyToMany
    @JoinTable(
            name ="actor_episode",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="episode_id")
    )
    private Set<Episode> episode;

    @ManyToMany
    @JoinTable(
            name ="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private Set<Movie> movie;
}
