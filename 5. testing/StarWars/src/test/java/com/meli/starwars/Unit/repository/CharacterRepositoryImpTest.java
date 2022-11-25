package com.meli.starwars.Unit.repository;

import com.meli.starwars.entity.Character;
import com.meli.starwars.repository.CharacterRepositoryImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CharacterRepositoryImpTest {

    @Mock
    private CharacterRepositoryImp characterRepositoryImp;

    @Test
    void getAllCharacterContainingName() {
        //ARRANGE
        //ACT
        List<Character> characterList = characterRepositoryImp.getAllCharacterContainingName(anyString());
        //ASSERT
        assertNotNull(characterList);
    }
}