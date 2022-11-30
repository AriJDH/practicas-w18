package com.example.Deportista.repository;

import com.example.Deportista.entity.Deporte;

import java.util.ArrayList;

public class DeportesRepository {

    public static ArrayList<Deporte> deportes = new ArrayList<>(){
        {
            add(new Deporte("futbol","Amateur"));
            add(new Deporte("Baloncesto","Profesional"));
            add(new Deporte("Voleyball","Medio"));
            add(new Deporte("Beisbol","Medio"));
        }

    };






    public static ArrayList<Deporte> getDeportes(){
        return deportes;
    }


}
