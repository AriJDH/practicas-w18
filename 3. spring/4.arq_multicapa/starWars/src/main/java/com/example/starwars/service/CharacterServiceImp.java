package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.Character;
import com.example.starwars.repository.CharacterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class CharacterServiceImp implements IcharacterService{

    CharacterRepository characterRepository = new CharacterRepository();

    @Override
    public List<CharacterDTO> findAllCharacters() {
        ObjectMapper op = new ObjectMapper();

        List<Character> characterList = characterRepository.findAllCharacters();

        List<CharacterDTO> characterDTOList = characterList.stream()
                .map(char1 -> op.convertValue(char1.getName(), CharacterDTO.class))
                .collect(Collectors.toList());
        return characterDTOList;
    }

    @Override
    public List<CharacterDTO> findByName(String character) {
        return null;
    }
}
