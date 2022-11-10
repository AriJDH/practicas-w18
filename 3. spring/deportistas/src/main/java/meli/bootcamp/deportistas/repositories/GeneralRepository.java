package meli.bootcamp.deportistas.repositories;


import lombok.Getter;
import meli.bootcamp.deportistas.entities.Deporte;
import meli.bootcamp.deportistas.entities.Persona;

import java.util.ArrayList;

@Getter
public class GeneralRepository
{
    ArrayList<Persona> listaPersona = new ArrayList<>();
    ArrayList<Deporte> listaDeporte = new ArrayList<>();

    public GeneralRepository()
    {
        listaPersona.add(new Persona("nom1", "ape1", 30));
        listaPersona.add(new Persona("nom2", "ape2", 20));
        listaPersona.add(new Persona("nom3", "ape2", 15));
        listaPersona.add(new Persona("nom4", "ape3", 25));
        listaDeporte.add(new Deporte("dep1", "a"));
        listaDeporte.add(new Deporte("dep2", "b"));
        listaDeporte.add(new Deporte("dep3", "c"));
        listaDeporte.add(new Deporte("dep4", "d"));
    }


    public Deporte findDeporteByNombre(String nombre)
    {
        for (Deporte d :
                listaDeporte) {
            if (nombre.equals(d.getNombre()))
                return d;
        }
        return null;
    }
}
