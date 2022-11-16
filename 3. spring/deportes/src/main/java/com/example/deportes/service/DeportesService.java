package com.example.deportes.service;

import com.example.deportes.repositorio.DeportesRepositorio;
import com.example.deportes.Interfaces.DeportesPersonaService;
import com.example.deportes.dto.DeportesDTO;
import com.example.deportes.entity.Deportes;

import java.util.ArrayList;
import java.util.List;


public class DeportesService implements DeportesPersonaService {
    private DeportesRepositorio deportesDAO = new DeportesRepositorio();
    @Override
    public List<DeportesDTO> buscarTodos() {
        deportesDAO.setDeportes();
        List<Deportes> deportes = deportesDAO.getDeportes();
        List<DeportesDTO> deportesDTO = new ArrayList<>();

        for (Deportes d: deportes ){
            DeportesDTO desporteDTO = new DeportesDTO(d.getNombre(), d.getNivel());
            deportesDTO.add(desporteDTO);
        }

        return deportesDTO;
    }
}
