package com.meli.lgutierrez.complementario.ejercicio1;

public class Profesor extends Personal implements Enseñanza{

    public Profesor(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("Realizo labores profesorales");
    }

    @Override
    public void enseñar() {
        System.out.println("Doy clases a los estudiantes matriculados en mi curso");
    }
}
