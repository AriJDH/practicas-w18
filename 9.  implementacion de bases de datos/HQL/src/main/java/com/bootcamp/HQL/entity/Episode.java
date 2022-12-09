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
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    private String title;

    private Integer number;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Season season;

    @ManyToMany(mappedBy = "episode")
    private Set<Actor> actors;
}
