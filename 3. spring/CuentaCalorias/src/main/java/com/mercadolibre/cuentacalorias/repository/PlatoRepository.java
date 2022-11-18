package com.mercadolibre.cuentacalorias.repository;

import com.mercadolibre.cuentacalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository{
    private List<Plato> platos = new ArrayList<>();

    @Override
    public List<Plato> getAll() {
        return this.platos;
    }

    @Override
    public Plato getByName(String name) {
        return this.platos
                .stream()
                .filter(i->i.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No existe el plato"));
    }

    @Override
    public Plato create(Plato plato) {
        this.platos.add(plato);
        return plato;
    }
}
