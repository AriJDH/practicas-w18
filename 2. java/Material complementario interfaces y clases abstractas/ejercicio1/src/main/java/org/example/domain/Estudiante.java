package org.example.domain;

public class Estudiante extends Universitario{
    //atributos propios
    public Estudiante(String nombre, String legajo) {
        super(nombre, legajo);
    }
    @Override
    public void saludar(){
        super.saludar();
        System.out.println("Soy un estudiante");
    }
}
