package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.PlatoDTO;
import com.spring.calculadoracalorias.entity.Plato;
import com.spring.calculadoracalorias.repository.IPlatoRepositorio;
import com.spring.calculadoracalorias.repository.PlatoRepositorioImp;
import org.springframework.stereotype.Service;

@Service
public class PlatoServicioImp implements IPlatoServicio{

    private IPlatoRepositorio iPlatoRepositorio;

    public PlatoServicioImp(PlatoRepositorioImp platoRepositorioImp){
        this.iPlatoRepositorio = platoRepositorioImp;
    }

    @Override
    public PlatoDTO buscarPlato(String nombre, int gramos) {
        Plato plato = iPlatoRepositorio.obtenerPlato(nombre);
        return new PlatoDTO(plato.calcularCaloriasTotales(gramos), plato.getListaIngredientes(), plato.calcularIngMaxCalorias());
    }
}