public class Usuario {
    private int id = 0;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;

    public Usuario( String dni, String nombre, String apellido, int edad, String celular) {
        this.id = id + 1;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                '}';
    }
}
