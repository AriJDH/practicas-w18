package com.example.demo.service;

import com.example.demo.dto.response.PersonaDto;
import com.example.demo.entity.Persona;
import com.example.demo.repository.IPersonaRepository;
import com.example.demo.repository.PersonaRepositoryImp;
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

        /*List<PersonaDto> personaDtosMapper = personas.stream()
                .map(p-> op.convertValue(p.getClass()))
                .collect(Collectors.toList());*/

        List<PersonaDto> personaDtos = personas.stream()
                .map(p-> new PersonaDto(p.getNombre(), p.getApellido(), p.getEdad()))
                .collect(Collectors.toList());


        return  personaDtos;
    }
}
