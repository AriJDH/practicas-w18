package Ejercicio2;

public class Curriculums implements Documento{
    private String nombre;
    private String apellido;
    private int edad;
    private String profesion;

    public Curriculums(String nombre, String apellido, int edad, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Curriculums{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
