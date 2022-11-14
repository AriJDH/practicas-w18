package com.spring.multicapa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.multicapa.dto.PersonaDto;
import com.spring.multicapa.entity.Persona;
import com.spring.multicapa.repository.IPersonaRepository;
import com.spring.multicapa.repository.PersonaRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonaService{

    private IPersonaRepository personaRepository = new PersonaRepositoryImp();

    @Override
    public List<PersonaDto> getPersonas() {
        List<Persona> personas = personaRepository.findAll();

        //PARA MAPEAR ENTIDADES PERSONA A PERDONADTO
        List<PersonaDto> personasDto = personas.stream()
               .map(p-> new PersonaDto(p.getNombre(), p.getApellido(), p.getEdad()))
               .collect(Collectors.toList());

        //OTRA FORMA DE MAPEAR, SOLO FUNCIONA SI TIENE LOS MISMOS ATRIBUTOS, NOMBRE Y CANTIDAD
        ObjectMapper op = new ObjectMapper();

        List<PersonaDto> personaDtos1 = personas.stream()
                .map(p-> op.convertValue(p, PersonaDto.class))
                .collect(Collectors.toList());

        return personasDto;
    }
}
