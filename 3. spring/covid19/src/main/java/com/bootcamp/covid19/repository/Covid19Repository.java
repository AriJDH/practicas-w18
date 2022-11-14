package com.bootcamp.covid19.repository;

import com.bootcamp.covid19.dto.response.PersonaDtoResponse;
import com.bootcamp.covid19.dto.response.SintomaDtoResponse;
import com.bootcamp.covid19.entity.Persona;
import com.bootcamp.covid19.entity.Sintoma;

import java.util.*;

public class Covid19Repository implements  ICovid19Repository{
   List<Persona> personas = new ArrayList<Persona>();
   List<Sintoma> sintomas = new ArrayList<Sintoma>();
   int contador = 1;

    @Override
    public List<Persona> listaPersona() {
        Persona p = new Persona((long) contador++,"Janeth", "Martinez",50,listaSintomas());
        Persona p1 = new Persona((long) contador++,"Alexander", "Hipatl", 75,listaSintomas());
        Persona p2 = new Persona((long) contador++,"Carmela", "Perez", 58, listaSintomas());
        Persona p3 = new Persona((long) contador++,"Adolfo", "Lopez", 62,listaSintomas());
        personas.add(p);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        return personas;
    }



    @Override
    public List<Sintoma> listaSintomas() {
        Sintoma s = new Sintoma("F", "Fiebre", "5");
        Sintoma s1 = new Sintoma("T","Tos", "5");
        Sintoma s2 = new Sintoma("C", "Cansancio", "5");
        Sintoma s3 = new Sintoma("PG", "Perdida de gusto", "5");
        Sintoma s4 = new Sintoma("PO", "PerdidaOlfato", "5");
        sintomas.add(s);
        sintomas.add(s1);
        sintomas.add(s2);
        sintomas.add(s3);
        return sintomas;
    }

}
