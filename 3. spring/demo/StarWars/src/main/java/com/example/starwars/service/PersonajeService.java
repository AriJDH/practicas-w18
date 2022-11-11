package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeDTO;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    private final IPersonajeRepository personajeRepository = new PersonajeRepository();
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public List<PersonajeDTO> getPersonajeByName(String name) {
        List<PersonajeDTO> personajes = personajeRepository
                .getPersonajesByName(name)
                .stream()
                .map(p -> mapper.map(p, PersonajeDTO.class))
                .collect(Collectors.toList());
        return personajes;
    }

}
