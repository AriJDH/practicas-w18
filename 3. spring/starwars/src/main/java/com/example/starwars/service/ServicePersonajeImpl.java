package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePersonajeImpl implements IServicePersonaje {

    @Autowired
    private IRepository repository;

    @Override
    public List<PersonajeDTO> consultarPersonajesPorNombre(String nombre) {

        List<Personaje> personajes = this.repository.consultarEntidadPorNombre(nombre);

        return personajes.stream()
                .map(p -> new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies()))
                .collect(Collectors.toList());
    }
}
