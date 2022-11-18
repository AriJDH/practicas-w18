package com.playground.appmulticapa.controller;

import com.playground.appmulticapa.dto.request.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PersonaController {

    @GetMapping
    public ResponseEntity<List<PersonDto>> showList();
}
