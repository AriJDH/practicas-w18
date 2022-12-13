package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.service.IActorService;
import com.mercadolibre.movies.service.IGenreService;
import com.mercadolibre.movies.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoviesDBController {
    private final IMovieService movieService;
    private final IActorService actorService;
    private final IGenreService genreService;

    /**
     * TODO Listar todos los actores que tengan declarada una película favorita.
     */

    /**
     * TODO Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
     */

    /**
     * TODO Listar todos los actores que trabajan en la <película recibida por parámetro>
     */

    /**
     * TODO Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
     */

    /**
     * TODO Listar todas las películas que pertenezcan al <género recibido por parámetro>
     */

    /**
     * TODO Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
     */

    /**
     * TODO Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
     */

}
