package org.example.models;

import java.util.List;

public class Mantenimiento extends Personal{

    private List<String> listaMantenimiento;


    public Mantenimiento(String name, String lastName, int dni, int year, List<String> listaMantenimiento) {
        super(name, lastName, dni, year);
        this.listaMantenimiento = listaMantenimiento;
    }

    public void mantenimiento() {
        System.out.println("Realizando mantenimiendo de: \n" + listaMantenimiento);
    }
}
