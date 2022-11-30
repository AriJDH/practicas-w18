package com.starwars.starwars.repository;

import com.starwars.starwars.entity.Personaje;

public interface PersonajeRepository {

    Personaje findPersonajeByName(String name);

}
