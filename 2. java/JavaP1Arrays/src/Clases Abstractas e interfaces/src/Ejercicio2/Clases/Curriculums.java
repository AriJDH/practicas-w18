package Ejercicio2.Clases;

import Ejercicio2.Interfaces.IImprimir;
import Ejercicio2.Modelos.Persona;

public class Curriculums implements IImprimir<Persona> {

    Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Curriculums(Persona persona) {
        setPersona(persona);
    }

    @Override
    public void imprimir() {
        System.out.println(getPersona());
    }
}
