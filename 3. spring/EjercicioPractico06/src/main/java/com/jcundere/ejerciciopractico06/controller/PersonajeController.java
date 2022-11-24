package com.jcundere.ejerciciopractico06.controller;

import com.jcundere.ejerciciopractico06.dto.response.PersonajeResponse;
import com.jcundere.ejerciciopractico06.service.IPersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonajeController {

    private final IPersonajeService personajeService;

    @GetMapping("/search/{name}")
    public ResponseEntity<List<PersonajeResponse>> searchPersonajeByName(@PathVariable String name) {

        List<PersonajeResponse> result = personajeService.searchPersonajeListByName(name);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
