package com.example.deportistas.repositories;

import com.example.deportistas.domain.Deporte;

import java.util.Optional;

public class DeporteRepository extends ListRepository<Deporte>{
    public Optional<Deporte> findDeporteByName(String name){
        return super.findAll().stream().filter(d->d.getNombre().equals(name)).findFirst();
    }
}
