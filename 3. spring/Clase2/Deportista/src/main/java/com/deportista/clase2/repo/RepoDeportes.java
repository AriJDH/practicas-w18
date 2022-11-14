package com.deportista.clase2.repo;

import com.deportista.clase2.entity.Deporte;

import java.util.ArrayList;

public class RepoDeportes {
    private static ArrayList<Deporte> deportes = new ArrayList<Deporte>();

    static{
        deportes.add(new Deporte("Futbol", "Facil"));
        deportes.add(new Deporte("Hockey", "Medio"));
        deportes.add(new Deporte("Basket", "Dificil"));
    }

    public static ArrayList<Deporte> getDeportes() {
        return deportes;
    }
}