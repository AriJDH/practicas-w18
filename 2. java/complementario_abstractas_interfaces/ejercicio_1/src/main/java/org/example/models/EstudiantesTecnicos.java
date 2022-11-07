package org.example.models;

import java.util.List;

public class EstudiantesTecnicos extends Estudiantes implements ITecnicable{

    private List<String> listaReparacion;

    public EstudiantesTecnicos(String name, String lastName, int dni, int year, int legajo, List<String> listaReparacion) {
        super(name, lastName, dni, year, legajo);
        this.listaReparacion = listaReparacion;
    }

    @Override
    public void soporteTecnico() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ". Legajo: " + getLegajo() + ", estudiante técnico y parte de soporte técnico.");
    }

    public void reparacion() {
        System.out.println("Reparando la lista de reparación: \n" + listaReparacion);
    }
}
