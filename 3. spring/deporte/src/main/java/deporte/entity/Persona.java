package deporte.entity;

import java.util.List;

public class Persona {
    private Integer id = 0;
    private String nombre;
    private String apellido;
    private  Integer edad;
    private List<Deporte> deportes;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, List<Deporte> deportes) {
        this.id +=1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportes = deportes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
