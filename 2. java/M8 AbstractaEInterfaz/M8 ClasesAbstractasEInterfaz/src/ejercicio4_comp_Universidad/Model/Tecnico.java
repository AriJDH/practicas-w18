package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionSoporteTecnico;

public class Tecnico extends Estudiante implements FuncionSoporteTecnico {
    public Tecnico(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Tecnico " + super.toString();
    }
}
