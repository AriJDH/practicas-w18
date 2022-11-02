package ejercicio4_comp_Universidad.Model;

public class Estudiante extends Persona {
    public Estudiante(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Estudiante \t" + super.toString();
    }
}
