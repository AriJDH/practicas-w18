package com.covid.covid.repository;

import com.covid.covid.model.Persona;
import com.covid.covid.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<Persona> personas = new ArrayList<>();
    List<Sintoma> sintomas = new ArrayList<>();

    public List<Persona> getPersonas() {
        Persona p1= new Persona(1,"Pepe","Diaz",65);
        Persona p2= new Persona(2,"Lili","Rey",21);
        Persona p3= new Persona(3,"Blanca","Pandiella",22);
        Persona p4= new Persona(4,"Ricardo","Milla",15);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

        return personas;
    }

    public List<Sintoma> getSintomas() {
        Sintoma s1=new Sintoma("A1","Tos",1);
        Sintoma s2=new Sintoma("A2","Tos",2);
        Sintoma s3=new Sintoma("B1","Fiebre",2);
        Sintoma s4=new Sintoma("C1","Nauseas",2);
        Sintoma s5=new Sintoma("D1","Dolor Muscular",2);

        sintomas.add(s1);
        sintomas.add(s2);
        sintomas.add(s3);
        sintomas.add(s4);
        sintomas.add(s5);

        return sintomas;
    }
}
