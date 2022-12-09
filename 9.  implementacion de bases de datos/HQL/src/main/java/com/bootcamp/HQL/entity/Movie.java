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
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    private String title;
    private Double raiting;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Genre genre;

    @ManyToMany(mappedBy = "movie")
    private Set<Actor> actors;
}
