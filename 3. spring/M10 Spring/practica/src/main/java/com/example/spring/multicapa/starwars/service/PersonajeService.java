package com.example.spring.multicapa.starwars.service;

import com.example.spring.multicapa.starwars.dto.PersonajeDTOResponse;
import com.example.spring.multicapa.starwars.entity.Personaje;
import com.example.spring.multicapa.starwars.repository.IPersonajeRepository;
import com.example.spring.multicapa.starwars.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    //Necesito esta dependencia para trabajar con el repositorio
    IPersonajeRepository iPersonajeRepository = new PersonajeRepository();


    @Override
    public List<PersonajeDTOResponse> getAll() {
        List<Personaje> personajes = iPersonajeRepository.findAll();
        List<PersonajeDTOResponse> personajesDTOresponse = getPersonajeDTOResponseMapper(personajes);
        return personajesDTOresponse;
    }

    @Override
    public List<PersonajeDTOResponse> findByName(String name) {

        List<Personaje> personajesPorNombre = iPersonajeRepository.findByName(name);
        List<PersonajeDTOResponse> personajesDTOresponse = getPersonajeDTOResponseMapper(personajesPorNombre);

        return personajesDTOresponse;
    }

    private List<PersonajeDTOResponse> getPersonajeDTOResponseMapper(List<Personaje> personajes) {
        ObjectMapper objectMapper = new ObjectMapper();

        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return personajes.stream()
                .map(p -> objectMapper.convertValue(p, PersonajeDTOResponse.class))
                .collect(Collectors.toList());
    }
}
