package ejercicio4_comp_Universidad.Model;

import ejercicio4_comp_Universidad.Intefaz.FuncionDocencia;

public class Docente extends Persona implements FuncionDocencia {
    public Docente(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Docente    \t\t\t" + super.toString();
    }
}
