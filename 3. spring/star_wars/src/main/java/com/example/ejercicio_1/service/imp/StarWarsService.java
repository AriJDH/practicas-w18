package com.example.ejercicio_1.service.imp;

import com.example.ejercicio_1.dto.PersonajeDTO;
import com.example.ejercicio_1.repository.IStarWarsRepository;
import com.example.ejercicio_1.repository.imp.StarWarsRepository;
import com.example.ejercicio_1.service.IStarWarsService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService implements IStarWarsService {

    private IStarWarsRepository personajeRepository=new StarWarsRepository();
    private ObjectMapper mapper=new ObjectMapper();

    @Override
    public List<PersonajeDTO> findByName(String name) {
        List<PersonajeDTO>persojeDtos=new ArrayList<>();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        personajeRepository.findByName(name).forEach(p -> persojeDtos.add(mapper.convertValue(p,PersonajeDTO.class)));
        return persojeDtos;
    }
}
