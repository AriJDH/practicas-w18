package com.example.starwars.service;

import com.example.starwars.dto.resp.CharacterDTO;

import java.util.List;

public interface IPersonajeService {
    List<CharacterDTO> getCharacters(String name);

}
