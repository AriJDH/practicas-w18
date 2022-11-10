package EjercicioPG2;

import java.util.ArrayList;

public class PersonaDTO {
    String nombreCompleto;
    int edad;
    ArrayList<Sintoma> sintomas;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Sintoma> getSintomas() {
        return this.sintomas;
    }

    public void setSintomas(ArrayList<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
