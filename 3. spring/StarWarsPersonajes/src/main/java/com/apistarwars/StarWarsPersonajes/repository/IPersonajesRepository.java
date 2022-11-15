package com.apistarwars.StarWarsPersonajes.repository;

import com.apistarwars.StarWarsPersonajes.entity.Personaje;

import java.util.List;

public interface IPersonajesRepository {
    public List<Personaje> retornarListaPersonajes();
}
