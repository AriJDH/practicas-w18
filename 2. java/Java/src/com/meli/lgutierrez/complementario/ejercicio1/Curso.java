package com.meli.lgutierrez.complementario.ejercicio1;

import java.util.List;

public class Curso {

    private String nombreCurso;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String nombreCurso, Profesor profesor, List<Estudiante> estudiantes) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        String respuesta = "";
        for (Estudiante estudiante : estudiantes) {
            respuesta += estudiante.getNombre() + " tiene las funciones: " + estudiante.getFunciones() + ". ";
        }
        return "El curso " + nombreCurso + " es dirigido por el profesor " + profesor.getNombre() + " y tiene los siguientes alumno: \n" + respuesta;
    }
}
