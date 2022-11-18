package com.example.Multicapa.service;

import com.example.Multicapa.dto.request.PersonaDTO;
import com.example.Multicapa.entity.Persona;
import com.example.Multicapa.repository.IPersonaRepository;
import com.example.Multicapa.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository= new PersonaRepositoryImp();

    @Override
    public List<PersonaDTO> getPersona() {
        ObjectMapper op = new ObjectMapper();
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDTO> personasDTO= personas.stream()
                .map(p->op.convertValue(p,PersonaDTO.class))
                .collect(Collectors.toList());
        return personasDTO;
    }
}
