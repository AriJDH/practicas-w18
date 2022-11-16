package com.meli.lgutierrez.complementario.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Estudiante estudianteBase = new EstudianteBase("Laura", "1050084", "Aprender de los cursos inscritos");
        Estudiante estudianteTutor = new EstudianteTutor(new EstudianteBase("Jhon", "1050250", "Aprender de los cursos inscritos"));
        Estudiante estudianteSoporte = new EstudianteSoporte(new EstudianteBase("Celeste", "1050689", "Aprender de los cursos inscritos"));

        Profesor profesor = new Profesor("Juan Carlos");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudianteBase);
        estudiantes.add(estudianteSoporte);
        estudiantes.add(estudianteTutor);

        Curso curso = new Curso("Calculo", profesor, estudiantes);

        System.out.println(curso);
    }
}
