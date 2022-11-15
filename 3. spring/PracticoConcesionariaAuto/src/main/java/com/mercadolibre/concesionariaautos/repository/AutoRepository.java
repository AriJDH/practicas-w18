package com.mercadolibre.concesionariaautos.repository;

import com.mercadolibre.concesionariaautos.entity.Auto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoRepository implements IAutoRepository{
    List<Auto> listaAutos = new ArrayList<>();
    @Override
    public void agregarAuto(Auto auto) {
        listaAutos.add(auto);
    }

    @Override
    public List<Auto> mostrarListaAutos() {
        return listaAutos;
    }
}
