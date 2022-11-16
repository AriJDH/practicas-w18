package com.meli.lgutierrez.complementario.ejercicio1;

public class EstudianteSoporte implements Estudiante{

    private Estudiante estudiante;

    public EstudianteSoporte(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public void aprender() {
        System.out.println("Aprendo de los cursos que se me asignaron con una intesidad horaria menor para poder coloborar en mantenimiento");
    }

    @Override
    public String getNombre() {
        return estudiante.getNombre();
    }

    @Override
    public String getCodigo() {
        return estudiante.getCodigo();
    }

    @Override
    public String getFunciones() {
        return estudiante.getFunciones() + " y labores de mantenimiento";
    }
}
