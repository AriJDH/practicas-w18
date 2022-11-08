package Class;

import java.util.ArrayList;

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private String contacto;
    ArrayList<String> habilidades;

    public Persona(String nombre, String apellido, String dni, String contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contacto = contacto;
        this.habilidades = new ArrayList<>();
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", contacto='" + contacto + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
