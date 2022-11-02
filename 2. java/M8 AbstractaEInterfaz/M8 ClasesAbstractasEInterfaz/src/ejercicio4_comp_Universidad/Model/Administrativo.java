package ejercicio4_comp_Universidad.Model;

public class Administrativo extends Persona {

    public Administrativo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Administrativo " + super.toString();
    }
}
