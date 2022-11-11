package com.spring.starwars.service;

import com.spring.starwars.dto.CharacterDtoRes;

import java.util.List;

public interface ICharacterService {
    List<CharacterDtoRes> findCharacters(String name);
}
