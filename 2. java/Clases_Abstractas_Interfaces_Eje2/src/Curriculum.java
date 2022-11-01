import java.util.Arrays;

public class Curriculum implements Imprimible{

    private String nombre;   //Lo ideal seria realizar una clase persona
    private int edad;
    private String telefono;
    private String[] habilidades;

    public Curriculum(String nombre, int edad, String telefono, String[] habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }
}
