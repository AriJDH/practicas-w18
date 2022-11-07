package org.example;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Personal personal = new Personal("Carlos","Espinosa",1234566,30);
        System.out.println("------------ MIEMBROS DEL PERSONAL ------------");
        personal.presentarse();

        List<String> lMantenimiento = new ArrayList<>();
        lMantenimiento.add("Limpiar");
        lMantenimiento.add("Ordenar");

        Mantenimiento mantenimiento = new Mantenimiento("Juan","Martinez",45677783,29, lMantenimiento);
        System.out.println("\n------------ MIEMBROS DE MANTENIMIENTO ------------");
        mantenimiento.presentarse();
        mantenimiento.mantenimiento();

        List<String> lMaterias = new ArrayList<>();
        lMaterias.add("Matematica");
        lMaterias.add("Fisica");

        Profesores profesores = new Profesores("Pedro","Suarez",84635362,45, lMaterias);
        System.out.println("\n------------ PROFESORES ------------");
        profesores.tutor();
        profesores.enseniar();

        List<String> lSoporte = new ArrayList<>();
        lSoporte.add("Reparar");
        lSoporte.add("Conectar");

        Soporte soporte = new Soporte("Pablo","Gonzalez",6785373,25,lSoporte);
        System.out.println("\n------------ MIEMBROS DE SOPORTE ------------");
        soporte.soporteTecnico();
        soporte.soporte();

        Estudiantes estudiantes = new Estudiantes("Lucas","Lopez",832723,20,111222);
        System.out.println("\n------------ ESTUDIANTES ------------");
        estudiantes.presentarse();

        EstudiantesTecnicos estudiantesTecnicos = new EstudiantesTecnicos("Gonzalo","Garcia",98765,23,383,lSoporte);
        System.out.println("\n------------ ESTUDIANTES TECNICOS ------------");
        estudiantesTecnicos.soporteTecnico();
        estudiantesTecnicos.reparacion();

        Tutores tutores = new Tutores("Martin","Ortiz",876545,25,983,lMaterias);
        System.out.println("\n------------ TUTORES ------------");
        tutores.tutor();
        tutores.enseniar();
    }
}