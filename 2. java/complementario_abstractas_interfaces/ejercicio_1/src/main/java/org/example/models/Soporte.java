package org.example.models;

import java.util.List;

public class Soporte extends Personal implements ITecnicable{

    private List<String> listaSoporte;

    public Soporte(String name, String lastName, int dni, int year, List<String> listaSoporte) {
        super(name, lastName, dni, year);
        this.listaSoporte = listaSoporte;
    }

    @Override
    public void soporteTecnico() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ". Soporte técnico de la institución.");
    }

    public void soporte() {
        System.out.println("Brindando soporte a: \n" + listaSoporte);
    }
}
