package Entity;

public class Cliente {
    private String DNI;
    private String nombre;
    private String apellido;

    public Cliente(String DNI, String nombre, String apellido) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
    }



    @Override
    public String toString() {
        return "Cliente {" +
                "DNI: '" + DNI + '\'' +
                ", Nombre: '" + nombre.toUpperCase() + '\'' +
                ", Apellido: '" + apellido.toUpperCase() + '\'' +
                '}';
    }

    public void imprimirDatos(){
        System.out.println(toString());
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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
