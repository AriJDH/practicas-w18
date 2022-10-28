package Ejercicio2;

public class Persona {
    private String nombre;
    private int edad;
    private String profesion;
    private String experiencia;

    @Override
    public String toString() {
        return "Nombre=" + nombre +
                "Edad=" + edad +
                "Profesion=" + profesion +
                "Experiencia=" + experiencia;
    }

    public Persona(String nombre, int edad, String profesion, String experiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.experiencia = experiencia;
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

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
