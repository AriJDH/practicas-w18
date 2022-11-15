package com.ejerciciospring.ejercicios_spring.practica2_dto_response.repository;

import com.ejerciciospring.ejercicios_spring.practica2_dto_response.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository implements IDataRepository <Deporte> {

    private List<Deporte> deportes = new ArrayList<>();

    @Override
    public Deporte crear(Deporte objeto) {

        deportes.add(objeto);

        return objeto;
    }

    @Override
    public List<Deporte> consultar() {
        return deportes;
    }

    @Override
    public Deporte consultarPorNombre(String nombre) {
        return deportes.stream().filter(x -> x.getNombre().equals(nombre)).findAny().orElse(null);
    }

}
