package Clases;

import Interfaz.Impresion;
import java.util.List;
import java.util.ArrayList;

public class Curriculums implements Impresion {
    List<String> habilidades = new ArrayList<String>();
    private Persona persona;

    public Curriculums(Persona persona,List <String> habilidades) {
        this.persona=persona;
        this.habilidades = habilidades;
    }

    @Override
    public String imprimir() {
        return "Este es el curriculum de " + persona.getNombre() + " cuya profesión es " + persona.getProfesion() +
                " con "+persona.getExperiencia()+" años de experiencia. "+ "\n" +"Sus habilidades son: "+ habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
