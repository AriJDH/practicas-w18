package com.example.demodeportistas.repository;

import com.example.demodeportistas.entity.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {

    public List<Deporte> deportes;

    public DeporteRepository() {
        this.deportes = new ArrayList<>();
        deportes.add(new Deporte("futbol", "principiante"));
        deportes.add(new Deporte("voleibol", "profesional"));
        deportes.add(new Deporte("yudo", "principiante"));

    }



}
