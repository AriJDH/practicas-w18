package com.example.starwars.service;

import com.example.starwars.dto.resp.CharacterDTO;

import java.util.List;

public interface PersonajeService {
    List<CharacterDTO> getCharacters(String name);

}
