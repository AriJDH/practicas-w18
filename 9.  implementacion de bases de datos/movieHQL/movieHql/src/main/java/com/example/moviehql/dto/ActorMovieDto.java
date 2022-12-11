package com.example.moviehql.dto;

import lombok.Data;

@Data
public class ActorMovieDto {
    ActorDto actor;
    MovieDto favoriteMovie;
}
