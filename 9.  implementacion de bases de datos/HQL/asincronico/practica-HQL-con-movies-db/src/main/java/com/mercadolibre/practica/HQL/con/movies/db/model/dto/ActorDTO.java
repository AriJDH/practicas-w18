package com.mercadolibre.practica.HQL.con.movies.db.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActorDTO {
    Integer id;
    String firstName;
    String lastName;
    Double rating;
    Integer favoriteMovieId;
}
