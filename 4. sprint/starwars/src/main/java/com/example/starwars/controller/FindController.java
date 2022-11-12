package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDto;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import com.example.starwars.service.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindController {
    //@Autowired
    //private FindService findService;

    private CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
    private FindService findService = new FindService(characterRepository);


    @GetMapping("/{query}")
    public List<CharacterDto> find(@PathVariable String query){
        return findService.find(query);
    }

    @GetMapping("/api/{query}")
    public String findQuery(@PathVariable String query){
        return query;
    }
}
