package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IcharacterService {
    List<CharacterDTO> findByName(String character);
    List<CharacterDTO> findAllCharacters();
}
