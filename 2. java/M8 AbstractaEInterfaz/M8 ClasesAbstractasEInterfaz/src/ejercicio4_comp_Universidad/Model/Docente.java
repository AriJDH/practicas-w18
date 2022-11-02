package ejercicio4_comp_Universidad.Model;

public class Docente extends Persona {
    public Docente(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Docente " + super.toString();
    }
}
