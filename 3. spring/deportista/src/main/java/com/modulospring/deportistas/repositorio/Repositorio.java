package com.modulospring.deportistas.repositorio;

import com.modulospring.deportistas.entity.Deporte;
import com.modulospring.deportistas.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class Repositorio implements IRepositorio{

    @Override
    public List<Persona> addListPerson() {
        List<Persona> personaList = new ArrayList<Persona>();
        Persona persona = new Persona("Janeth", "Martinez", 29, addListSport() );
        Persona persona1 = new Persona("Diego", "Hipatl", 9, addListSport() );
        Persona persona2 = new Persona("Valentina", "Martinez", 1, addListSport() );
        Persona persona3 = new Persona("Alexander", "Martinez", 10, addListSport() );
        personaList.add(persona);
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        return personaList;
    }

    @Override
    public List<Deporte> addListSport() {
        List<Deporte> deporteList = new ArrayList<Deporte>();
        Deporte deporte = new Deporte("Natacion", "Basico");
        Deporte deporte1 = new Deporte("Futbol", "Basico");
        Deporte deporte2 = new Deporte("Basquetball", "Basico");
        deporteList.add(deporte);
        deporteList.add(deporte1);
        deporteList.add(deporte2);
        return deporteList;
    }

}
