package com.mercadolibre.practica.HQL.con.movies.db.model.dto.response;

import com.mercadolibre.practica.HQL.con.movies.db.model.Actor;
import com.mercadolibre.practica.HQL.con.movies.db.model.Movie;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.ActorDTO;
import com.mercadolibre.practica.HQL.con.movies.db.model.dto.MovieDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ActorMovieDTOResponse {
    ActorDTO actor;
    MovieDTO movie;


}
