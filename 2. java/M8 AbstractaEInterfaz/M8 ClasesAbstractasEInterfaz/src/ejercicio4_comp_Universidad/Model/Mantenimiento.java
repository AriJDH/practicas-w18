package ejercicio4_comp_Universidad.Model;

public class Mantenimiento extends Persona {
    public Mantenimiento(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mantenimiento " + super.toString();
    }
}
