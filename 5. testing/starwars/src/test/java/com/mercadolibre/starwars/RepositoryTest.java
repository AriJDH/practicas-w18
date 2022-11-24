package com.mercadolibre.starwars;

import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private CharacterRepositoryImpl characterRepository;

    @Test
    public void doesFindLuke(){
        Assertions.assertTrue(characterRepository.findAllByNameContains("Luke").size()>0);
    }

    @Test
    public void doesNotFindMarcelo(){
        Assertions.assertEquals(characterRepository.findAllByNameContains("Marcelo").size(),0);
    }
}
