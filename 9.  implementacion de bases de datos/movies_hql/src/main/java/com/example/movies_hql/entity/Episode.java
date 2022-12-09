package com.example.movies_hql.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;
}
