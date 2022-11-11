package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.service;

import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.dto.PersonajeDTO;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.entity.Personaje;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.repository.IRepository;
import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.repository.RepositoryPersonajeImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePersonajeImpl implements IServicePersonaje {

    private IRepository repository = new RepositoryPersonajeImpl();

    @Override
    public List<PersonajeDTO> consultarPersonajesPorNombre(String nombre) {

        List<Personaje> personajes = this.repository.consultarEntidadPorNombre(nombre);

        return personajes.stream()
                .map(p -> new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies())).collect(Collectors.toList());
    }
}
