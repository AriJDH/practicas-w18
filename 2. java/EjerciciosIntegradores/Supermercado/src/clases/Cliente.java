package clases;

public class Cliente {
    private long dni;
    private String nombre;
    private String apellido;

    public Cliente(long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  "dni=" + getDni() + '\n' +
                "nombre='" + getNombre() + '\n' +
                "apellido='" + getApellido() + '\n' ;
    }

    public String getApellido() {
        return apellido;
    }

    public void mostrarCliente() {
        toString();
    }
}
