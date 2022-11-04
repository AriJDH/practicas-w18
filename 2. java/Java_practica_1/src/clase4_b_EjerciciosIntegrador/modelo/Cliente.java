package clase4_b_EjerciciosIntegrador.modelo;

public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

    public Long getId() {
        return id;
    }

    public Cliente(Long id, String nombre, String apellido, String dni, String nroContacto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nroContacto = nroContacto;
    }

    public void setId(Long id) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNroContacto() {
        return nroContacto;
    }

    public void setNroContacto(String nroContacto) {
        this.nroContacto = nroContacto;
    }

    private String nroContacto;
}
