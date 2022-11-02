package Clases;

import Interfaces.IDarSoporteTecnico;

public class PersonalSoporteTecnico extends Personal implements IDarSoporteTecnico {
    public PersonalSoporteTecnico(String apellido, String nombre, int edad) {
        super(apellido, nombre, edad);
    }

    @Override
    public void brindarSoporteTecnico() {
        System.out.println("Brindando soporte tecnico...");
    }
}
