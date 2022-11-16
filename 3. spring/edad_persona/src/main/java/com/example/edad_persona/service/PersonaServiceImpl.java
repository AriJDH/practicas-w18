package com.example.edad_persona.service;

import com.example.edad_persona.domain.Deporte;
import com.example.edad_persona.domain.Persona;
import com.example.edad_persona.dto.DeporteDto;
import com.example.edad_persona.dto.PersonaDto;
import com.example.edad_persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public List<PersonaDto> findAll() {
        List<PersonaDto> personas = new ArrayList<>();

        for(Persona persona : personaRepository.findAll()){
            PersonaDto personaDto = new PersonaDto(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
            personas.add(personaDto);
        }
        return personas;
    }
}
