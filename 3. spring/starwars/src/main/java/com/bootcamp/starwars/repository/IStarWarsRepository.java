package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {
    List<Personaje> cargarLista();
}
