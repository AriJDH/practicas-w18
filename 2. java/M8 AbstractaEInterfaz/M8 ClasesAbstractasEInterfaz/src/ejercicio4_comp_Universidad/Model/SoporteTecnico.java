package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionSoporteTecnico;

public class SoporteTecnico extends Persona implements FuncionSoporteTecnico {
    public SoporteTecnico(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SoporteTecnico " + super.toString();
    }
}
