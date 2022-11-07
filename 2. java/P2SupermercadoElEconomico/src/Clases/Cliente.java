package Clases;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;


    //Constructor
    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {
    }

    //To string
    @Override
    public String toString() {
        return "Cliente:" + "\n"+
                "  dni= " + dni + "\n"+
                "  Nombre= " + nombre + '\n' +
                "  Apellido= " + apellido + '\n' +
                "-----------------" ;
    }

    //Getters and Setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
}

