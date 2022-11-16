package com.example.edad_persona.repository;

import com.example.edad_persona.domain.Deporte;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DeporteRespositoryImpl implements DeporteRepository{

    private List<Deporte> deportes = Arrays.asList(new Deporte("Hockey", 5),new Deporte("Fútbol", 4),
            new Deporte("Tenis", 3), new Deporte("Basquet", 4));
    @Override
    public List<Deporte> findAll() {
        return deportes;
    }

    @Override
    public Optional<Deporte> findByNombre(String nombre){

        return deportes.stream().filter( d -> d.getNombre().equals(nombre)).findFirst();
    }
}
