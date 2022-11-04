package Impresora.Models;

public class Persona {
    String Nombre;
    int Edad;
    Habilidades Habilidades;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Edad=" + Edad +
                ", Habilidades=" + Habilidades +
                '}';
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public Habilidades getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(Habilidades habilidades) {
        Habilidades = habilidades;
    }
}
