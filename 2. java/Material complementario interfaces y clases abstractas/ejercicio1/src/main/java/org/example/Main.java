package org.example;

import org.example.domain.Estudiante;
import org.example.domain.EstudianteTecnico;
import org.example.domain.Tutor;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("Rodrigo", "1111111");
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Norberto", "222222");
        Tutor tutor = new Tutor("Ricardo","3333333" );
        estudiante.saludar();
        estudianteTecnico.saludar();
        tutor.saludar();
    }
}