package com.deportista.deportistas.repository;

import com.deportista.deportistas.model.Deporte;
import com.deportista.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<Persona> personas= new ArrayList<>();
    List<Deporte> deportes=new ArrayList<>();

    public List<Persona> getPersonas() {

        Deporte d1 = new Deporte("Natacion",1);
        Deporte d2 = new Deporte("Natacion",2);
        Deporte d3 = new Deporte("BodyCombat",1);
        Deporte d4 = new Deporte("BodyCombat",2);
        Deporte d5 = new Deporte("BodyCombat",3);
        Deporte d6 = new Deporte("Voley",1);

        List<Deporte> deportes = new ArrayList<>();
        deportes.add(d1);
        deportes.add(d4);
        deportes.add(d5);
        deportes.add(d6);

        List<Deporte> deportes2 = new ArrayList<>();
        deportes2.add(d2);
        deportes2.add(d3);

        Persona p1 = new Persona("Nini","Perez",23,deportes);
        Persona p2 = new Persona("Juan","Diaz",26,deportes2);
        Persona p3 = new Persona("Lili","Rey",33,deportes);
        Persona p4 = new Persona("Blanca","Pandiella",36,deportes2);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        return personas;
    }

    public List<Deporte> getDeportes() {
        Deporte d1 = new Deporte("Natacion",1);
        Deporte d2 = new Deporte("Natacion",2);
        Deporte d3 = new Deporte("BodyCombat",1);
        Deporte d4 = new Deporte("BodyCombat",2);
        Deporte d5 = new Deporte("BodyCombat",3);
        Deporte d6 = new Deporte("Voley",1);

        this.deportes.add(d1);
        this.deportes.add(d2);
        this.deportes.add(d3);
        this.deportes.add(d4);
        this.deportes.add(d5);
        this.deportes.add(d6);

        return this.deportes;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }
}


