package com.ejerciciospring.ejercicios_spring.practica2_dto_response.repository;

import com.ejerciciospring.ejercicios_spring.practica2_dto_response.model.Deporte;
import com.ejerciciospring.ejercicios_spring.practica2_dto_response.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements IDataRepository <Persona> {

    private List<Persona> personas = new ArrayList<>();

    @Override
    public Persona crear(Persona objeto) {

        personas.add(objeto);

        return objeto;
    }

    @Override
    public List<Persona> consultar() {
        return personas;
    }

    @Override
    public Persona consultarPorNombre(String nombre) {
        //no tiene impl
        return null;
    }


}
