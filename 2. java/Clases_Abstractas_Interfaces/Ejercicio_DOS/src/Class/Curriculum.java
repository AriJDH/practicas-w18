package Class;

import Interface.Imprimible;
import Class.Persona;

public class Curriculum implements Imprimible {

    private String fecha;
    private Persona persona;

    public Curriculum(String fecha, Persona persona) {
        this.fecha = fecha;
        this.persona = persona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void imprimir(){
        System.out.println("FECHA: " + this.getFecha() + "Persona: " + this.getPersona().toString());
    }
}
