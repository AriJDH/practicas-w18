public class Inscripto {
    int dni;
    String nombre, apellido;
    int edad;
    int celular, nroDeEmergencia;
    String grupoSanguineo;
    int circuito;

    public Inscripto(int dni, String nombre, String apellido, int edad, int celular, int nroDeEmergencia, String grupoSanguineo, int circuito) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroDeEmergencia = nroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.circuito = circuito;
    }

    public Inscripto() {
        //No-args constructor
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNroDeEmergencia() {
        return nroDeEmergencia;
    }

    public void setNroDeEmergencia(int nroDeEmergencia) {
        this.nroDeEmergencia = nroDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
