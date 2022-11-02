package ejercicio4_comp_Universidad.Model;

public class SoporteTecnico extends Persona {
    public SoporteTecnico(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "SoporteTecnico " + super.toString();
    }
}
