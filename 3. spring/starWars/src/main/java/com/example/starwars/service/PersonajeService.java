package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.PersonajeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    private PersonajeRepositoryImpl repository = new PersonajeRepositoryImpl();

    @Override
    public List<PersonajeDTO> getPersonajes() {

        List<Personaje> personajes = repository.getListOfChars();
        List<PersonajeDTO> personajesDTO = new ArrayList<>();

        for (Personaje p: personajes ){
            PersonajeDTO personajeDTO = new PersonajeDTO(
                    p.getName(),
                    p.getMass(),
                    p.getHeight(),
                    p.getHomeworld(),
                    p.getGender(),
                    p.getSpecies());
            personajesDTO.add(personajeDTO);
        }

        return personajesDTO;
    }

    @Override
    public List<PersonajeDTO> getPersonajeByName(String name) {

        List<Personaje> personajes = repository.findByName(name);
        List<PersonajeDTO> personajesDTO = new ArrayList<>();

            for (Personaje p: personajes ){
                PersonajeDTO personajeDTO = new PersonajeDTO(
                        p.getName(),
                        p.getMass(),
                        p.getHeight(),
                        p.getHomeworld(),
                        p.getGender(),
                        p.getSpecies());
                personajesDTO.add(personajeDTO);
            }

            return personajesDTO;
    }
}
