package com.example.deportistas.repositorio;

import com.example.deportistas.entity.Deporte;

import java.util.ArrayList;
import java.util.List;

public abstract class DeportesRepo {
    public static ArrayList<Deporte> lista = new ArrayList<>();
    static{
        lista.add(new Deporte("Futbol","Amateur"));
        lista.add(new Deporte("Futbol","Profesional"));
        lista.add(new Deporte("Basquetbol","Amateur"));
        lista.add(new Deporte("Basquetbol","Profesional"));
    }

}
