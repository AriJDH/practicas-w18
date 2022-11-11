package com.example.starwarsapi.service;

import com.example.starwarsapi.dto.request.PersonajeDto;
import com.example.starwarsapi.entity.Personaje;
import com.example.starwarsapi.repository.IPersonajeRepository;
import com.example.starwarsapi.repository.PersonajeRepositoryImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService{
    private IPersonajeRepository personajeRepository = new PersonajeRepositoryImp();

    @Override
    public List<PersonajeDto> findAll() {
        ObjectMapper op = new ObjectMapper();


        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeDto> personajesDTO =
                personajes.stream()
                        .map(p -> op.convertValue(p, PersonajeDto.class))
                        .collect(Collectors.toList());
        return personajesDTO;
    }
}
