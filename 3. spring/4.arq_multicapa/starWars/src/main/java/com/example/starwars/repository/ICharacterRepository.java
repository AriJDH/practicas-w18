package com.example.starwars.repository;

import com.example.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICharacterRepository {
    public List<Character> findAllCharacters();
}
