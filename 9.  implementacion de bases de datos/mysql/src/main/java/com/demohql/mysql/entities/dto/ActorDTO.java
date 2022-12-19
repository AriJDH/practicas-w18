package com.demohql.mysql.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActorDTO {

    Integer id;
    String firstName;
    String lastName;
    Double rating;
    Integer favoriteMovieId;

}
