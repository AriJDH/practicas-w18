package com.example.multicapa.service;

import com.example.multicapa.dto.request.PersonaDto;
import com.example.multicapa.entity.Persona;
import com.example.multicapa.repository.IPersonaRepository;
import com.example.multicapa.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository;

    @Override
    public List<PersonaDto> getPersonas() {
        ObjectMapper op = new ObjectMapper();


        personaRepository = new PersonaRepositoryImp();
        List<Persona> personas = personaRepository.finAll();
        List<PersonaDto> personasDto = personas.stream()
                .map(p -> op.convertValue(p, PersonaDto.class))
                .collect(Collectors.toList());
        return personasDto;
    }
}
