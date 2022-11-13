package com.example.multicapa.service;

import com.example.multicapa.dto.request.PersonaDto;
import com.example.multicapa.entity.Persona;
import com.example.multicapa.repository.IPersonaRepository;
import com.example.multicapa.repository.PersonaRepoImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaServiceImp implements IPersonaService {

    private IPersonaRepository personaRepository;

    @Override
    public List<PersonaDto> getPErsona() {
        ObjectMapper op = new ObjectMapper();


        personaRepository = new PersonaRepoImp();

        List<Persona> personas = personaRepository.findAllPersonas();
        List<PersonaDto> personasDto = personas.stream()
                .map(p -> op.convertValue(p, PersonaDto.class))
                .collect(Collectors.toList());


        return personasDto;
    }
}
