package com.example.multicapa.demo.service;

import com.example.multicapa.demo.dto.resp.PersonaDTO;
import com.example.multicapa.demo.entity.Persona;
import com.example.multicapa.demo.repository.IPersonaRepository;
import com.example.multicapa.demo.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository = new PersonaRepositoryImp();

    @Override
    public List<PersonaDTO> getPersonas(){
        ObjectMapper op = new ObjectMapper();
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDTO> personaDTO= personas.stream()
                .map(p-> op.convertValue(p, PersonaDTO.class))
                .collect(Collectors.toList());
        return personaDTO;
    }
}
