package com.meli.lgutierrez.complementario.ejercicio1;

public class PersonalSoporte extends Personal implements Soporte{


    public PersonalSoporte(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("Realizo labores de soporte");
    }

    @Override
    public void darSoporte() {
        System.out.println("Doy soporte a las actividades asignadas");
    }
}
