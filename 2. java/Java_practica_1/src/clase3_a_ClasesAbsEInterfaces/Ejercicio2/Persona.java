package clase3_a_ClasesAbsEInterfaces.Ejercicio2;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public Persona(String nombre, String apellido, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
