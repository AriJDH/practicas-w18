package com.spring.starwars.controller;

import com.spring.starwars.dto.CharacterDtoRes;
import com.spring.starwars.service.CharacterService;
import com.spring.starwars.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/figuren")
public class CharacterController {

    ICharacterService characterService = new CharacterService();

    @GetMapping()
    public ResponseEntity<List<CharacterDtoRes>> getChars(@RequestParam String name) {
        return new ResponseEntity<>(characterService.findCharacters(name), HttpStatus.OK);
    }
}
