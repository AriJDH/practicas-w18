package com.example.covid19.controller;

import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class CovidController {

    private ArrayList<Sintoma> sintomas;
    private ArrayList<Persona> personas;

    private void cargar() {
        sintomas = new ArrayList<Sintoma>();

        Sintoma s1 = new Sintoma("S1", "Fiebre", 1);
        Sintoma s2 = new Sintoma("S2", "Tos", 1);
        Sintoma s3 = new Sintoma("S3", "Dolor de garganta", 1);
        Sintoma s4 = new Sintoma("S4", "Dificultad para respirar", 2);
        Sintoma s5 = new Sintoma("S5", "Dolor de cabeza", 1);
        Sintoma s6 = new Sintoma("S6", "Dolor muscular", 1);

        sintomas.add(s1);
        sintomas.add(s2);
        sintomas.add(s3);
        sintomas.add(s4);
        sintomas.add(s5);
        sintomas.add(s6);

        // cargar personas
        personas = new ArrayList<Persona>();

        Persona p1 = new Persona(1, "Juan", "Perez", 59);
        Persona p2 = new Persona(2, "Maria", "Gomez", 25);
        Persona p3 = new Persona(3, "Pedro", "Gonzalez", 35);
        Persona p4 = new Persona(4, "Jose", "Rodriguez", 65);

        // cargar sintomas de algunas peronas
        ArrayList<Sintoma> sintomas_p1 = new ArrayList<Sintoma>();
        sintomas_p1.add(s1);
        sintomas_p1.add(s2);
        p1.setSintomas(sintomas_p1);

        ArrayList<Sintoma> sintomas_p4 = new ArrayList<Sintoma>();
        sintomas_p4.add(s1);
        sintomas_p4.add(s3);
        p4.setSintomas(sintomas_p4);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);

    }

    // ver todos los sintomas cargados
    @GetMapping("/findSymptom")
    public String findSymptom() {
        cargar();
        String res = "";
        for (Sintoma s : sintomas) {
            res += s.toString() + " ";
        }
        return res;
    }

    // buscar sintoma por nombre
    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String nombre) {
        cargar();
        for (Sintoma s : sintomas) {
            if (s.getNombre().equals(nombre)) {
                return ResponseEntity.ok(s.getNombre() + " " + s.getNivel_de_gravedad());
            }
        }
        return ResponseEntity.badRequest().body("No se encontro el sintoma");
    }


    // ver personas de riesgo, si tienen mas de 60 y algun sintoma, son de riesgo
    // retornar nombre y apellido de las personas de riesgo
    @GetMapping("/findRiskPerson")
    public String findRiskPerson() {
        cargar();
        String res = "";
        for (Persona p : personas) {
            if (p.getEdad() > 60) {
                if (p.getSintomas() != null) {
                    res += p.getNombre() + " " + p.getApellido() + " ";
                }
            }
        }
        return res;
    }





}
