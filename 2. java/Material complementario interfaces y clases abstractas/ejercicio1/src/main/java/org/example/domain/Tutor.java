package org.example.domain;

public class Tutor extends Estudiante implements FuncionTutor{
    public Tutor(String nombre, String legajo) {
        super(nombre, legajo);
    }
    @Override
    public void saludar(){
        super.saludar();
        this.darTutoria();
    }
}
