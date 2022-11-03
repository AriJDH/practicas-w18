package Ejercicio1;

public abstract class Persona {

    // Atributos
    protected String nombre;
    protected String apellido;
    protected Integer dni;

    // Constructores
    public Persona(String nombre,
                   String apellido,
                   Integer dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }

    // Método abstracto
    public abstract void anunciarse();
}
