package com.example.deportistas.repositories;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeportistaRepositoryImpl implements DeportistaRepository {

    // private final List<Deporte> deportes;
    List<Deporte> deportes = new ArrayList<>();
    List<DeportistaDto> deportistas = new ArrayList<>();


    DeportistaRepositoryImpl() {
        loadDbDeportes();
        loadDbDeportistas();
    }

    ;

    @Override
    public List<Deporte> getDeportes() {
        return deportes;
    }

    @Override
    public Deporte getDeporte(String deporte) {
        Deporte res = deportes.stream()
                .filter(d -> d.getNombre().equals(deporte))
                .findFirst()
                .orElse(null);

        return res;
    }

    @Override
    public List<DeportistaDto> getDeportistas() {
        return deportistas;
    }

    private List<Deporte> loadDbDeportes() {
        Deporte tennis = new Deporte("tenis", "amateur");
        Deporte futbol = new Deporte("futbol", "amateur");
        Deporte basquet = new Deporte("basquet", "amateur");
        deportes.add(tennis);
        deportes.add(futbol);
        deportes.add(basquet);

        return deportes;
    }

    private void loadDbDeportistas() {
        Persona p1 = new Persona("Lucas", "Padula", 24);
        DeportistaDto dt1 = new DeportistaDto(p1, deportes);

        Persona p2 = new Persona("Mauro", "Padula", 24);
        DeportistaDto dt2 = new DeportistaDto(p2, deportes);

        deportistas.add(dt1);
        deportistas.add(dt2);
    }
}
