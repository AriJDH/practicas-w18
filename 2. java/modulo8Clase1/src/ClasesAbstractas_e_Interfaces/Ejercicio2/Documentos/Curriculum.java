package ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos;

import java.util.List;

public class Curriculum extends Documento {
    private String dni;
    private int edad;
    private String nombre;
    private List<String> habilidades;

    public Curriculum(String dni, int edad, String nombre, List<String> habilidades) {
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "dni='" + dni + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
