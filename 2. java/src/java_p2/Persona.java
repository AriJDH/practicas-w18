package java_p2;

public class Persona {

    private String dni;
    private String nombreCompleto;
    private int edad;
    private String celular;
    private String numEmergencia;
    private String grupoSanguineo;

    public Persona(String dni, String nom, int edad, String celu, String numEmer, String grupoSan) {
        this.dni = dni;
        nombreCompleto = nom;
        this.edad = edad;
        celular = celu;
        numEmergencia = numEmer;
        grupoSanguineo = grupoSan;
    }


    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + "\nDni: " + dni + "\nEdad: " + edad + "\nCelular: " + celular +
                "\nNum Emergencia: " + numEmergencia + "\nGrupo Sanguineo: " + grupoSanguineo;
    }
}
