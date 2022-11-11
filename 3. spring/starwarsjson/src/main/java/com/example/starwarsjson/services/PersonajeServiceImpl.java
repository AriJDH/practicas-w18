package com.example.starwarsjson.services;

import com.example.starwarsjson.DTOs.PersonajeDTO;
import com.example.starwarsjson.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService{
    @Autowired
    private PersonajeRepository personajeRepository;
    @Override
    public List<PersonajeDTO> findAllPersonajeDTO() {
        return personajeRepository.findAll().stream().map(p->new PersonajeDTO(p)).collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDTO> findAllPersonajeDTOByName(String name) {
        return personajeRepository.findByName(name).stream().map(p->new PersonajeDTO(p)).collect(Collectors.toList());
    }
}
