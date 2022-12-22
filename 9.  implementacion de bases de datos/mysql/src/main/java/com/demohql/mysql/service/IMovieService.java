package com.demohql.mysql.service;

import com.demohql.mysql.entities.dto.ActorDTO;
import com.demohql.mysql.entities.dto.ActorMovieResponseDTO;

public interface IMovieService {

    ActorMovieResponseDTO getMovieByName(String name);
}
