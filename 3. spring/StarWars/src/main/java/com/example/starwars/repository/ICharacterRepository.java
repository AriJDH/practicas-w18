package com.example.starwars.repository;

import com.example.starwars.entity.Personaje;

import java.util.List;

public interface ICharacterRepository {

    List<Personaje> findAllByName(String name);
}
