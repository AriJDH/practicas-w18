package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.repository;

import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model.Sintoma;
import com.ejerciciospring.ejercicios_spring.repository.IRepository;

import java.util.Arrays;
import java.util.List;

public class SintomaRepository implements IRepository<Sintoma> {

    private List<Sintoma> sintomas;

    public SintomaRepository() {
        sintomas = Arrays.asList(
                new Sintoma("100", "Gripa", 2),
                new Sintoma("100", "Covid", 5));
    }

    @Override
    public void crear(Sintoma entidad) {
        //No se implementa
    }

    @Override
    public List<Sintoma> consultarEntidades() {
        return sintomas;
    }

    @Override
    public Sintoma consultarEntidadPorNombre(String nombre) {
        return sintomas.stream().filter(x -> x.getNombre().equals(nombre)).findAny().orElse(null);
    }
}
