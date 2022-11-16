package com.example.edad_persona.service;

import com.example.edad_persona.domain.Deporte;
import com.example.edad_persona.dto.DeporteDto;
import com.example.edad_persona.repository.DeporteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements DeporteService{

    private final DeporteRepository deporteRepository;

    public DeporteServiceImpl(DeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }


    @Override
    public List<DeporteDto> findAll() {
        List<DeporteDto> deportes = new ArrayList<>();

        for(Deporte deporte : deporteRepository.findAll()){
            DeporteDto deporteDto = new DeporteDto(deporte.getNombre(), deporte.getNivel());
            deportes.add(deporteDto);
        }
        return deportes;
    }

    @Override
    public DeporteDto findByName(String name) {
        Optional<Deporte> deporte = deporteRepository.findByNombre(name);
        if(deporte.isPresent()) {
            return new DeporteDto(deporte.get().getNombre(), deporte.get().getNivel());
        }
        return null;
    }
}
