package com.meli.lgutierrez.complementario.ejercicio1;

public class EstudianteTutor implements Estudiante{

    private Estudiante estudiante;

    public EstudianteTutor(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public void aprender() {
        System.out.println("Aprendo de los cursos que se me asignaron con una intesidad horaria menor para poder ser tutor");
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
        return estudiante.getFunciones() + " y labores de tutor";
    }
}
