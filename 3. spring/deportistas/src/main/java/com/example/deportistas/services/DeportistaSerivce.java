package com.example.deportistas.services;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.repositories.DeportistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeportistaSerivce {
    private final DeportistaRepository deportistaRepository;

    public DeportistaSerivce(DeportistaRepository deportistaRepository) {
        this.deportistaRepository = deportistaRepository;
    }

    public List<Deporte> getDeportes() {
        return deportistaRepository.getDeportes();
    }

    public Deporte getDeporte(String deporte){
        return deportistaRepository.getDeporte(deporte);
    }

    public List<DeportistaDto> getDeportistas(){
        return deportistaRepository.getDeportistas();
    }
}
