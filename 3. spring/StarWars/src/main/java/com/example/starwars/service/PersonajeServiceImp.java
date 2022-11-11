package com.example.starwars.service;

import com.example.starwars.dto.resp.CharacterDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {
    private IPersonajeService personajeService = new PersonajeServiceImp();

    @Override
    public List<CharacterDTO> getCharacters(){
        ObjectMapper op = new ObjectMapper();
        List<Character> characters = personajeService.getCharacters();
        List<CharacterDTO> characterDTOS = characters.stream()
                .map(p-> op.convertValue(p, CharacterDTO.class))
                .collect(Collectors.toList());
        return characterDTOS;
    }

    @Override
    public List<CharacterDTO> getCharacters(String name) {
        return null;
    }
}
