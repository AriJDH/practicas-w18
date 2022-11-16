package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.StarWarsDtoResponse;

import java.util.List;

public interface IStarWarsService {
    List<StarWarsDtoResponse> mostrarPersonajePorNombre(String name);

}
