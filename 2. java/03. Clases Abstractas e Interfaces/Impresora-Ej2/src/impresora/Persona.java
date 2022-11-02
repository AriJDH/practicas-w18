package impresora;

public class Persona {
    private String nombre;
    private String apellido;
    private String fechaDeNacimiento;

    public Persona(String nombre, String apellido, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Override
    public String toString() {
        return nombre + ' ' + apellido + '\n' +
                "Fecha De Nacimiento:" + fechaDeNacimiento + "\n";
    }
}
