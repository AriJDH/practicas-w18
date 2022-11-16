package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    IPersonajeRepository personajeRepository = new PersonajeRepository();

    @Override
    public List<PersonajeDto> findByName(String name) {

        List<PersonajeDto> personajesDto = personajeRepository.findAll()
                .stream()
                .filter(p -> p.getName().contains(name))
                .collect(Collectors.toList())
                .stream()
                .map(p -> new PersonajeDto(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies()))
                .collect(Collectors.toList());

        return personajesDto;
    }
}
