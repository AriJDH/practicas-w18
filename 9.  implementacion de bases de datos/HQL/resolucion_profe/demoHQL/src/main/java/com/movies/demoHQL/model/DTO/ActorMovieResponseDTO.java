package com.movies.demoHQL.model.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ActorMovieResponseDTO {

    ActorDTO actor;
    MovieDTO favoriteMovie;
}
