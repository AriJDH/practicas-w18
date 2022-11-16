package com.meli.lgutierrez.complementario.ejercicio1;

public class PersonalMatenimiento extends Personal{

    public PersonalMatenimiento(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("Realizo labores de mantenimiento");
    }
}
