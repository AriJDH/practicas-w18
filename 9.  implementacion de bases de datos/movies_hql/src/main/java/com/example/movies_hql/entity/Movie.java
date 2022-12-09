package com.example.movies_hql.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Integer id;

    private String title;

    private BigDecimal rating;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
