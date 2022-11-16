package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.StarWarsDtoResponse;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.IStarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService implements IStarWarsService{
    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<StarWarsDtoResponse> mostrarPersonajePorNombre(String name) {
        List<Personaje> listaPersonajes = starWarsRepository.cargarLista();
        List<StarWarsDtoResponse> listaPersonajesDto = listaPersonajes.stream()
                //hairColor, skinColor, eyeColor y birthYear quitar
                .filter(personaje -> personaje.getName().equals(name))
                .map(p-> StarWarsDtoResponse.builder()
                        .name(p.getName())
                        .height(p.getHeight())
                        .mass(p.getMass())
                        .homeworld(p.getHomeworld())
                        .gender(p.getGender())
                        .species(p.getSpecies())
                        .build())
                .collect(Collectors.toList());
        return listaPersonajesDto;
    }
}
