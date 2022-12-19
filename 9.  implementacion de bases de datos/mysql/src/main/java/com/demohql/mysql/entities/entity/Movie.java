package com.demohql.mysql.entities.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Double rating;
    private Integer awards;

    @Column(name="release_date")
    private Date releaseDate;

    Integer length;

    @Column(name="genre_id")
    private Integer genreId;

}
