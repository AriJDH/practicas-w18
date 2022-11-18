package com.mercadolibre.cuentacalorias.service;

import com.mercadolibre.cuentacalorias.repository.IIngredienteRepository;
import com.mercadolibre.cuentacalorias.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredienteService{
    IIngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }
}
