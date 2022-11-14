package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeResponseDto;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeResponseDto> mostrarPersonajesPorNombre(String name) {
        List<PersonajeResponseDto> listaPersonajesDto = new ArrayList<>();
        List<Personaje> listaPersonajes = personajeRepository.cargarLista();
        for (Personaje personaje : listaPersonajes) {
            if(personaje.getName().toUpperCase().contains(name.toUpperCase())){
                PersonajeResponseDto personajeDto = new PersonajeResponseDto(
                        personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies()
                );
                listaPersonajesDto.add(personajeDto);
            }
        }
        return listaPersonajesDto;
    }
}
