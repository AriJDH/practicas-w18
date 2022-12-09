package com.example.movies_hql.service;

import com.example.movies_hql.dto.ActorDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {

    List<ActorDTO> buscarActoresConPeliculaFavorita();

    List<ActorDTO> buscarActoresPorRating(BigDecimal rating);

    List<ActorDTO> buscarActoresPorPelicula(String nombrePelicula);

}
