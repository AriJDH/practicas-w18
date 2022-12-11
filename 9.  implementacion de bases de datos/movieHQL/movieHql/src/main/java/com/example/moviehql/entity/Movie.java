package com.example.moviehql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="movies")
@NamedQuery(name="MoviesByAwardsGreaterThan", query = "select m from Movie m where m.awards > :awards")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Double rating;
    private Integer awards;

    @Column(name = "release_date")
    private Date releaseDate;

    private Integer length;

    @Column(name = "genre_id")
    private Integer genreId;
}
