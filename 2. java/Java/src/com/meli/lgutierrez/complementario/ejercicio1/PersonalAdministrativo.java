package com.meli.lgutierrez.complementario.ejercicio1;

public class PersonalAdministrativo extends Personal{

    public PersonalAdministrativo(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("Realizo labores administrativas");
    }
}
