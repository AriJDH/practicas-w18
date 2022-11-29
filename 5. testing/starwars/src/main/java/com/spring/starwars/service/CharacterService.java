package com.spring.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.dto.CharacterDtoRes;
import com.spring.starwars.repository.CharacterRepository;
import com.spring.starwars.repository.ICharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    private ICharacterRepository characterRepository = new CharacterRepository();


    @Override
    public List<CharacterDtoRes> findCharacters(String name) {
        ObjectMapper op = new ObjectMapper();

        List<CharacterDtoRes> charactersDtoRes = characterRepository.findCharacters(name).stream()
                .map(c -> new CharacterDtoRes(
                        c.getName(),
                        c.getHeight(),
                        c.getMass(),
                        c.getGender(),
                        c.getHomeworld(),
                        c.getSpecies()))
                .collect(Collectors.toList());
        return charactersDtoRes;
    }

    @Override
    public List<CharacterDtoRes> getAllCharacters() {
        return characterRepository.getAllCharacters().stream()
                .map(c -> new CharacterDtoRes(
                        c.getName(),
                        c.getHeight(),
                        c.getMass(),
                        c.getGender(),
                        c.getHomeworld(),
                        c.getSpecies()))
                .collect(Collectors.toList());
    }
}
