package parte1;

public class Cliente {
    RepositorioBase repositorio;
    String nombre;
    long dni;

    public Cliente(RepositorioBase repositorio, String nombre, long dni) {
        this.repositorio = repositorio;
        this.nombre = nombre;
        this.dni = dni;
    }

    public RepositorioBase getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioBase repositorio) {
        this.repositorio = repositorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente\n" + repositorio +
                "\nnombre='" + nombre + '\'' +
                "\ndni=" + dni;
    }
}
