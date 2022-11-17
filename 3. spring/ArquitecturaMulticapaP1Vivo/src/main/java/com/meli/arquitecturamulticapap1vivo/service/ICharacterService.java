package com.meli.arquitecturamulticapap1vivo.service;

import com.meli.arquitecturamulticapap1vivo.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {
    List<CharacterDTO> getAllCharacterContainingName(String name);
}
