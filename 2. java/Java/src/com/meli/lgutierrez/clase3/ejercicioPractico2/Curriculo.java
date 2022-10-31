package com.meli.lgutierrez.clase3.ejercicioPractico2;

import java.util.List;

public class Curriculo implements TipoDocumento{
    private Persona persona;
    private List<String> habilidades;

    public Curriculo(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "------Imprimiendo Curriculo------\n" + persona + "\nTiene las siguientes habilidades: " + habilidades + "\n";
    }
}
