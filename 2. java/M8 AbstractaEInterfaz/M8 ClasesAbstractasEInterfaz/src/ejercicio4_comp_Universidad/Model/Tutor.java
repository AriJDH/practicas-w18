package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionTutor;

public class Tutor extends Estudiante implements FuncionTutor {
    public Tutor(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Tutor " + super.toString();
    }
}
