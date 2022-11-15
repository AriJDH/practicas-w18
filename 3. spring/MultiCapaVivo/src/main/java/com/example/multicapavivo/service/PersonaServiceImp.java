package com.example.multicapavivo.service;

import com.example.multicapavivo.dto.PersonaDto;
import com.example.multicapavivo.entity.Persona;
import com.example.multicapavivo.exceptions.NotFoundException;
import com.example.multicapavivo.repository.IPersonaRepository;
import com.example.multicapavivo.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository = new PersonaRepositoryImp();

    @Override
    public List<PersonaDto> getPersonas() {
        ObjectMapper op = new ObjectMapper();
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDto> personasDto = personas.stream()
                .map(p -> op.convertValue(p, PersonaDto.class))
                .collect(Collectors.toList());

        throw new NotFoundException("No se encontro nadaaa!");
        //return personasDto;
    }
}
