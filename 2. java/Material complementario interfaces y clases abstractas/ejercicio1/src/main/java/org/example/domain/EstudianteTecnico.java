package org.example.domain;

public class EstudianteTecnico extends Estudiante implements FuncionSoporte{
    public EstudianteTecnico(String nombre, String legajo) {
        super(nombre, legajo);
    }
    @Override
    public void saludar(){
        super.saludar();
        this.darSoporte();
    }
}
