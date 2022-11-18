package modelo;

public class Cliente {
    private static Long idClienteGlobal = 0l;
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String nroContacto;

    public Cliente(String nombre, String apellido, String dni, String nroContacto) {
        this.id = ++idClienteGlobal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroContacto = nroContacto;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNroContacto() {
        return nroContacto;
    }

    @Override
    public String toString() {
        return "Cliente " + id + ": " + nombre + " " + apellido;
    }
}
