package com.meli.starwars.service;

import com.meli.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getAllCharacterContainingName(String name);
}
