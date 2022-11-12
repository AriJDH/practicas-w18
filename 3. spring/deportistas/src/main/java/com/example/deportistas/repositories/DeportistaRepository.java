package com.example.deportistas.repositories;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;

import java.util.List;

public interface DeportistaRepository {
    List<Deporte> getDeportes();
    Deporte getDeporte(String  deporte);

    List<DeportistaDto> getDeportistas();
}
