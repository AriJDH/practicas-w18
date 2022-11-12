package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDto;

import java.util.List;

public interface CharacterRepository {
    List<CharacterDto> findAllByNameContains(String query);
}
