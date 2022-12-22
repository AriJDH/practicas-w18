package com.demohql.mysql.entities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActorMovieResponseDTO {
    private List<ActorDTO> actors;
    private MovieDTO movie;
}
