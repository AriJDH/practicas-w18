package com.mercadolibre.cuentacalorias.service;

import com.mercadolibre.cuentacalorias.dto.request.PlatoDTOCreate;
import com.mercadolibre.cuentacalorias.dto.response.PlatoDTORes;
import com.mercadolibre.cuentacalorias.entity.Plato;
import com.mercadolibre.cuentacalorias.repository.IIngredienteRepository;
import com.mercadolibre.cuentacalorias.repository.IPlatoRepository;
import com.mercadolibre.cuentacalorias.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PlatoService implements IPlatoService{
    IPlatoRepository platoRepository;
    IIngredienteRepository ingredienteRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public PlatoDTORes create(PlatoDTOCreate platoDTOCreate){
        Plato plato = new Plato();
        plato.setNombre(platoDTOCreate.getNombre());
        plato.setIngredientes(
                platoDTOCreate.getIngredientes()
                        .stream()
                        .map(i->ingredienteRepository.findByName(i))
                        .collect(Collectors.toList()));

        platoRepository.create(plato);

        return new PlatoDTORes(plato.getNombre());
    }


}
