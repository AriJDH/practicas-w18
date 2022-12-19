package com.demohql.mysql.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorMovieResponseDTO {
    private ActorDTO actor;
    private MovieDTO favoriteMovie;
}
