package com.example.starwarsmulticapa.service;

import com.example.starwarsmulticapa.dto.request.PersonajeDTO;
import com.example.starwarsmulticapa.entity.Personaje;
import com.example.starwarsmulticapa.repository.IPersonajeRepository;
import com.example.starwarsmulticapa.repository.PersonajeRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {
   @Override
    public List<PersonajeDTO> searchByName(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        IPersonajeRepository personajeRepository = new PersonajeRepositoryImp();
        //trae los datos necesarios
        List<Personaje> personajes = personajeRepository.listSelectPersonajes(name);
        //lista a devolver utilizando el mappeo
        List<PersonajeDTO> personajeDTOList = personajes.stream()
                .map(personaje -> objectMapper.convertValue(personaje, PersonajeDTO.class)).collect(Collectors.toList());
        return personajeDTOList;
    }


}
