package com.meli.lgutierrez.complementario.ejercicio1;

public class EstudianteBase implements Estudiante{

    private String nombre;
    private String codigo;
    private String funciones;


    public EstudianteBase(String nombre, String codigo, String funciones) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.funciones = funciones;
    }

    @Override
    public void aprender() {
        System.out.println("Aprendo de los cursos que se me asignaron");
    }

    @Override
    public String getNombre() {
        return nombre;
    }


    @Override
    public String getCodigo() {
        return codigo;
    }


    @Override
    public String getFunciones() {
        return funciones;
    }

}
