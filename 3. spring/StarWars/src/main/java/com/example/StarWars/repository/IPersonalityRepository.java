package com.example.StarWars.repository;

import com.example.StarWars.entity.Personality;

import java.util.List;

public interface IPersonalityRepository {
    List<Personality> findAllByName(String name);

}
