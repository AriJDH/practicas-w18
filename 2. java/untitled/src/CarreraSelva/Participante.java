package CarreraSelva;

public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;
    private int numeroInscripcion;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo, int numeroInscripcion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroInscripcion = numeroInscripcion;
    }



    public void Imprimir() {
        System.out.println("numero de Inscripción: " + numeroInscripcion);
        System.out.println("Dni: " + dni);
        System.out.println("nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Celular: " + celular);
        System.out.println("Numero de emergencia: " + numeroEmergencia);
        System.out.println("Grupo Sanguineo: " + grupoSanguineo);
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

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }
}
