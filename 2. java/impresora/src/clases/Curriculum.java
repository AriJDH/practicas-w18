package clases;

import Interface.Imprimible;
import superclase.Archivo;

public class Curriculum extends Archivo implements Imprimible {

    private Persona persona;

    public Curriculum(Persona persona) {

        this.persona = persona;

    }
}
