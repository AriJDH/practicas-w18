package com.meli.starwars.controller;

import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.service.CharacterServiceImp;
import com.meli.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CharacterController {
    @Autowired
    ICharacterService iCharacterService;

    @GetMapping("/findName/{name}")
    public ResponseEntity<List<CharacterDTO>> findName(@PathVariable String name){
        return new ResponseEntity<>(iCharacterService.getAllCharacterContainingName(name), HttpStatus.OK);
    }
}
