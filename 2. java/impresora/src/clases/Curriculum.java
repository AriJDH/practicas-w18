package clases;

import Interface.Imprimible;
import superclase.Archivo;

public class Curriculum extends Archivo {

    private Persona persona;

    public Curriculum(Persona persona) {

        this.persona = persona;

    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                '}';
    }


}
