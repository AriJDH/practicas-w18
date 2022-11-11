package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repositories.IPersonajeRepository;
import com.example.starwars.repositories.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp  implements IPersonajeService{

    private IPersonajeRepository personajeRepository = new PersonajeRepository();

    @Override
    public List<PersonajeDTO> getPersonajes(String query) {
        ObjectMapper op = new ObjectMapper();

        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOS = personajes.stream()//.filter(p -> p.getName().contains(query))
                .map(p -> op.convertValue(p, PersonajeDTO.class))
                .collect(Collectors.toList());
        return personajeDTOS;
    }
}
