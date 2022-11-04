package CarreraDeLaSelva.Models;

public class Participante {
    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getNumeroDeEmergencias() {
        return NumeroDeEmergencias;
    }

    public void setNumeroDeEmergencias(String numeroDeEmergencias) {
        NumeroDeEmergencias = numeroDeEmergencias;
    }

    public String getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        GrupoSanguineo = grupoSanguineo;
    }

    public long getConsecutivo() {
        return Consecutivo;
    }

    public void setConsecutivo(long consecutivo) {
        Consecutivo = consecutivo;
    }

    public float getValorPagar() {
        return ValorPagar;
    }

    public void setValorPagar(float valorPagar) {
        ValorPagar = valorPagar;
    }

    String Dni;
    String Nombre;
    String Apellido;
    int Edad;
    String Celular;
    String NumeroDeEmergencias;
    String GrupoSanguineo;
    long Consecutivo;
    float ValorPagar ;
}
