package Clases;

import Interfaces.IDarSoporteTecnico;

public class EstudianteTecnico extends Estudiante implements IDarSoporteTecnico {
    public EstudianteTecnico(String apellido, String nombre, int edad) {
        super(apellido, nombre, edad);
    }

    @Override
    public void brindarSoporteTecnico() {
        System.out.println("Brindando soporte tecnico...");
    }
}
