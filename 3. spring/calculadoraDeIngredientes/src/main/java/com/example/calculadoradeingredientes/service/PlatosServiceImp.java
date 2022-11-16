package com.example.CalculadoraDeIngredientes.service;

import com.example.CalculadoraDeIngredientes.dto.PlatoDto;
import com.example.CalculadoraDeIngredientes.entity.Plato;
import com.example.CalculadoraDeIngredientes.repository.IPlatosRepository;
import com.example.CalculadoraDeIngredientes.repository.PlatosRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatosServiceImp implements IPlatosService{
    private final IPlatosRepository platosRepository;
    //private final ObjectMapper mapper = new ObjectMapper();

    public PlatosServiceImp(PlatosRepositoryImp platosRepository) {
        this.platosRepository = platosRepository;
        //this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<PlatoDto> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        return platosRepository.getAll().stream()
                .map(plato -> mapper.convertValue(plato, PlatoDto.class))
                .collect(Collectors.toList());

    }
}
