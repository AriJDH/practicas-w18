package com.example.pr_grupal_dto_deportes.repos;

import com.example.pr_grupal_dto_deportes.entity.Deporte;

import java.util.ArrayList;

public abstract class RepoDeportes {
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
