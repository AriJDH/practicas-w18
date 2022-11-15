package com.apistarwars.StarWarsPersonajes.service;

import com.apistarwars.StarWarsPersonajes.dto.PersonajeDTO;
import com.apistarwars.StarWarsPersonajes.entity.Personaje;
import com.apistarwars.StarWarsPersonajes.repository.IPersonajesRepository;
import com.apistarwars.StarWarsPersonajes.repository.PersonajesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajesService implements IPersonajesService {

    IPersonajesRepository personajesRepository;

    public  PersonajesService(PersonajesRepository personajesRepository){
        this.personajesRepository=personajesRepository;

    }

    @Override
    public List<PersonajeDTO> retornarListaPersonajes(String nombre){
        List<PersonajeDTO> listaPersonajesDTO = new ArrayList<>();
        List<Personaje> personajes = personajesRepository.retornarListaPersonajes();
        for (Personaje personaje : personajes) {
            if (personaje.getName().toUpperCase().contains(nombre.toUpperCase())) {
                PersonajeDTO personajeDto = new PersonajeDTO(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                );
                listaPersonajesDTO.add(personajeDto);
            }
        }
        return listaPersonajesDTO;
    }
}


