package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionDocencia;

public class Tutor extends Estudiante implements FuncionDocencia {
    public Tutor(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Tutor " + super.toString();
    }
}
