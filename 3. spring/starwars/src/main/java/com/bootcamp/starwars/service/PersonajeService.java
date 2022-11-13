package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersojeDto;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import com.bootcamp.starwars.repository.PersonajeReporitoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    private IPersonajeRepository personajeRepository=new PersonajeReporitoryImp();
    private ObjectMapper mapper=new ObjectMapper();
    @Override
    public List<PersojeDto> findByName(String name) {
        List<PersojeDto>persojeDtos=new ArrayList<>();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        personajeRepository.findByName(name).forEach(p -> persojeDtos.add(mapper.convertValue(p,PersojeDto.class)));
        return persojeDtos;
    }



}
