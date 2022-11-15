package com.example.repaso.repository;

import com.example.repaso.entity.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DeporteRepository {

    private static ArrayList<Deporte> deportes = new ArrayList<Deporte>();

    static{
        deportes.add(new Deporte("Futbol", "Facil"));
        deportes.add(new Deporte("Hockey", "Medio"));
        deportes.add(new Deporte("Basket", "Dificil"));
    }

    public static ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public static Deporte findDeporte(String nombre){
        return deportes.stream().filter(d -> d.getName().equals(nombre)).findFirst().orElse(null);
    }
}
