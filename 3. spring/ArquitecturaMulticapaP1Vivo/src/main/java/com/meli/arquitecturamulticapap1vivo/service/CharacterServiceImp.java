package com.meli.arquitecturamulticapap1vivo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.arquitecturamulticapap1vivo.dto.CharacterDTO;
import com.meli.arquitecturamulticapap1vivo.entity.Character;
import com.meli.arquitecturamulticapap1vivo.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImp implements ICharacterService {

    @Autowired
    ICharacterRepository iCharacterRepository;

    @Override
    public List<CharacterDTO> getAllCharacterContainingName(String name) {
        return iCharacterRepository.getAllCharacterContainingName(name).stream()
                .map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeworld(), character.getSpecies())).
                collect(Collectors.toList());
    }
}
