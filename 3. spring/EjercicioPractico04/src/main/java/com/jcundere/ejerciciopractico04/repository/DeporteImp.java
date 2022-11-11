package com.jcundere.ejerciciopractico04.repository;

import com.jcundere.ejerciciopractico04.entity.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeporteImp implements CRUDRepository<Deporte> {

    private List<Deporte> listaDeportes = new ArrayList<>();


    public DeporteImp() {
        listaDeportes.add(new Deporte("Boxeo", "Intermedio"));
        listaDeportes.add(new Deporte("Karate", "Avanzado"));
        listaDeportes.add(new Deporte("Futbol", "Amateur"));
        listaDeportes.add(new Deporte("Basquet", "Amateur"));
        listaDeportes.add(new Deporte("Voley", "Amateur"));

    }


    public Optional<Deporte> buscar(String nombre) {
        for (Deporte deporte : listaDeportes
        ) {
            if (deporte.getNombre().equals(nombre)) {
                return Optional.of(deporte);
            }
        }
        return Optional.empty();
    }

    public List<Deporte> traeTodos() {
        return listaDeportes;
    }

    public void save(Deporte deporte) {
        listaDeportes.add(deporte);
    }

}
