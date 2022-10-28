package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    private String nombre;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String nombre) {
        this.nombre = nombre;
    }

    public void addHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void print() {
        System.out.printf("Nombre: " + this.nombre);
        if(habilidades.size()>0)
            habilidades.stream().forEach(habilidad-> System.out.println("-\n"+habilidad));
        else
            System.out.println("No tiene habilidades.");
    }
}
