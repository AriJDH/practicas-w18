package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.CharacterServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CharacterController {
    CharacterServiceImp characterServiceImp = new CharacterServiceImp();

    @GetMapping("/all")
    public ResponseEntity<List<CharacterDTO>> showCharacterList() {
        return new ResponseEntity<>(characterServiceImp.findAllCharacters(), HttpStatus.OK);
    }
}
