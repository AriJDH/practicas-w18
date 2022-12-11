package com.example.moviehql.dto;

import lombok.Data;

@Data
public class ActorDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Integer favoriteMovieId;
}
