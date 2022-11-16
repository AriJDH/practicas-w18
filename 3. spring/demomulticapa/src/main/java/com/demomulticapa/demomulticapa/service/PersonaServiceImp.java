package com.demomulticapa.demomulticapa.service;

import com.demomulticapa.demomulticapa.dto.PersonaDto;
import com.demomulticapa.demomulticapa.entity.Persona;
import com.demomulticapa.demomulticapa.repository.IPersonaRepository;
import com.demomulticapa.demomulticapa.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository = new PersonaRepositoryImp();


    @Override
    public List<PersonaDto> getPersona() {
        ObjectMapper op = new ObjectMapper();

        List<Persona> personas = personaRepository.findAll();
        List<PersonaDto> personasDto = personas.stream()
                .map(persona -> op.convertValue(persona,PersonaDto.class))
                .collect(Collectors.toList());
        return personasDto;

    }
}
