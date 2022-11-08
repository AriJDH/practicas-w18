package model;

public class Cliente {

    // Atributos
    private Long dni;
    private String nombre;
    private String apellido;

    // Constructores
    public Cliente() {
    }

    public Cliente(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public Long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    // Métodos
    @Override
    public String toString() {
        return "Cliente: \n" +
                "dni: " + dni +
                ", \n nombre:'" + nombre +
                ", \n apellido:'" + apellido;
    }
}
