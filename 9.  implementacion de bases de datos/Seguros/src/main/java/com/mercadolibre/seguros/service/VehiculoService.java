package com.mercadolibre.seguros.service;

import com.mercadolibre.seguros.entity.otros.PatenteMarca;
import com.mercadolibre.seguros.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService{
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<String> getPatentes() {
        return vehiculoRepository.getPatentes();
    }

    @Override
    public List<HashMap<String, String>> getPatenteMarcaOrdenadosPorAnio() {
        return vehiculoRepository.getPatenteMarcaOrdenadosPorAnio();
    }
}
