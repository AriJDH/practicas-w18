package com.meli.starwars.repository;

import com.meli.starwars.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getAllCharacterContainingName(String name);
}
