package clase3_a_ClasesAbsEInterfaces.Ejercicio2;

import java.util.List;

public class Curriculum implements Imprimible{

    private Persona persona;

    public Curriculum(String nombre, String apellido, List<String> habilidades) {
        this.persona = new Persona(nombre, apellido, habilidades);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                '}';
    }

}
