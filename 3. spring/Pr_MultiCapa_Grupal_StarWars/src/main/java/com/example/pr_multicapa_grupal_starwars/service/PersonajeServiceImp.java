package com.example.pr_multicapa_grupal_starwars.service;

import com.example.pr_multicapa_grupal_starwars.dto.PersonajeDto;
import com.example.pr_multicapa_grupal_starwars.entity.Personaje;
import com.example.pr_multicapa_grupal_starwars.repository.IPersonajeRepository;
import com.example.pr_multicapa_grupal_starwars.repository.PersonajeRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService{

    private IPersonajeRepository personajesRepository = new PersonajeRepositoryImp();

    @Override
    public List<PersonajeDto> findByName(String name) {
        return convertirPersonajesADto(this.personajesRepository.findByName(name));
    }

    @Override
    public List<PersonajeDto> findAll() {
        return convertirPersonajesADto(this.personajesRepository.findAll());
    }

    private List<PersonajeDto> convertirPersonajesADto(List<Personaje> personajes){
        ObjectMapper op = new ObjectMapper();
        List<PersonajeDto> personasDto = personajes.stream()
                .map(p -> op.convertValue(p, PersonajeDto.class))
                .collect(Collectors.toList());
        return personasDto;
    }
}

