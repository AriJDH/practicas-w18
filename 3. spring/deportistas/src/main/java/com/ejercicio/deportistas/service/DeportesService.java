package com.ejercicio.deportistas.service;


import com.ejercicio.deportistas.dto.DeporteDTO;
import com.ejercicio.deportistas.dto.DeporteDTONivel;
import com.ejercicio.deportistas.dto.DeportistaDTO;
import com.ejercicio.deportistas.entity.Deporte;
import com.ejercicio.deportistas.entity.Persona;
import com.ejercicio.deportistas.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeportesService {
    private Repository repository = new Repository();

    public DeporteDTONivel findSport(String nombre) {
        DeporteDTONivel deporteDTORes = new DeporteDTONivel();
        String nivel = repository.getAllDeportes().stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(nombre))
                .map(d -> d.getNivel())
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontró deporte con nombre " + nombre));
        deporteDTORes.setNivel(nivel);
        return deporteDTORes;
    }

    public List<DeporteDTO> getAllSports() {
        List<Deporte> deportes = repository.getAllDeportes();
        List<DeporteDTO> resDeportes = new ArrayList<>();

        for (Deporte d : deportes) {
            resDeportes.add(new DeporteDTO(d.getNombre(), d.getNivel()));
        } // :)

        return resDeportes;
    }

    public List<DeportistaDTO> findSportsPeople() {
        List<Persona> personas = repository.getAllPersonas();
        List<DeportistaDTO> deportistasDTO = new ArrayList<>();
        personas.stream()
                .filter(p -> !p.getDeportes().isEmpty())
                .forEach(p -> deportistasDTO.add(
                        new DeportistaDTO(
                                p.getNombre() + " " + p.getApellido(),
                                p.getDeportes().stream().map(d -> d.getNombre())
                                        .collect(Collectors.toList())))
                );
        return deportistasDTO;
    }
}
