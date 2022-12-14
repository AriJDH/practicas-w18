public class Cliente {

    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(){

    }

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString(){
        return "Datos personales del cliente: " + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "D.N.I: " + this.dni + "\n";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido(){
        return this.apellido;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getDni() {
        return this.dni;
    }



}
