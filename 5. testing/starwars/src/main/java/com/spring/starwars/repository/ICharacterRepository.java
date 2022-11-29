package com.spring.starwars.repository;

import com.spring.starwars.entity.Personaje;

import java.util.List;

public interface ICharacterRepository {
    List<Personaje> findCharacters(String name);
    List<Personaje> getAllCharacters();
}
