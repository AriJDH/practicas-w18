package com.meli.arquitecturamulticapap1vivo.repository;

import com.meli.arquitecturamulticapap1vivo.entity.Character;

import java.util.List;

public interface ICharacterRepository {
    List<Character> getAllCharacterContainingName(String name);
}
