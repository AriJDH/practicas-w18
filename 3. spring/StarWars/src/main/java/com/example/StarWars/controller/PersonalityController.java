package com.example.StarWars.controller;

import com.example.StarWars.dto.response.PersonalityDTO;
import com.example.StarWars.service.IPersonalityService;
import com.example.StarWars.service.PersonalityServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonalityController {

    private IPersonalityService personalityService = new PersonalityServiceImp();

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonalityDTO>> getByName(@PathVariable String name){
        return new ResponseEntity<>(personalityService.getPersonalitys(name), HttpStatus.OK);
    }

}
