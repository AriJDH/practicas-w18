package com.bootcamp.multicapa.service;

import com.bootcamp.multicapa.dto.PersonaDto;
import com.bootcamp.multicapa.entity.Persona;
import com.bootcamp.multicapa.repository.PersonaRepositoryImp;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{
    @Autowired
    PersonaRepositoryImp personaRepositoryImp;
    @Override
    public List<PersonaDto> finAll() {
        List<Persona> personaList = personaRepositoryImp.creaListaPersona();
        List<PersonaDto> personaDtoList = personaList.stream()
                .map(p -> new PersonaDto(p.getNombre(),p.getApellido(), p.getEdad()))
                .collect(Collectors.toList());
        return personaDtoList;
    }
}
