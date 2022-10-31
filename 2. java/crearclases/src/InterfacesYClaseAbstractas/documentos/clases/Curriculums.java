package InterfacesYClaseAbstractas.documentos.clases;

import InterfacesYClaseAbstractas.documentos.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Curriculums extends Persona implements Imprimible {

    private String[] habilidades;

    public Curriculums(String nombre, String apellido, String... habilidades) {
        super(nombre, apellido);
        this.habilidades = habilidades;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return  "nombre" + this.getNombre() +
                "apellido" + this.getApellido() +
                "habilidades=" + Arrays.toString(habilidades);
    }
}
