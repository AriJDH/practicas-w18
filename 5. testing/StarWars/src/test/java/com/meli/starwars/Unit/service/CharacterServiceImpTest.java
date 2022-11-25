package com.meli.starwars.Unit.service;

import com.meli.starwars.entity.Character;
import com.meli.starwars.repository.CharacterRepositoryImp;
import com.meli.starwars.repository.ICharacterRepository;
import com.meli.starwars.service.CharacterServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CharacterServiceImpTest {

    @Mock
    private CharacterRepositoryImp characterRepositoryImp;

    @InjectMocks
    private CharacterServiceImp characterServiceImp;

    @Test
    void getAllCharacterContainingName() {
        //ACT
        characterServiceImp.getAllCharacterContainingName(anyString());
        //ASSERT
        verify(characterRepositoryImp).getAllCharacterContainingName(any());
    }
}