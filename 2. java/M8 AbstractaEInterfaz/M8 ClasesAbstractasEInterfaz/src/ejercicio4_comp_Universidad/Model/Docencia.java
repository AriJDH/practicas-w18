package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionDocencia;

public class Docencia extends Estudiante implements FuncionDocencia {
    public Docencia(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Docencia " + super.toString();
    }
}
