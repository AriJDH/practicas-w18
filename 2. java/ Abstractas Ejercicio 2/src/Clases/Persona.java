package Clases;

public class Persona {
    private String nombre;
    private int edad;
    private String profesion;
    private int experiencia;

    public Persona(String nombre, int edad, String profesion, int experiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + '\n' +
                ", edad=" + edad +
                ", profesion=" + profesion + '\n' +
                ", experiencia=" + experiencia ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
