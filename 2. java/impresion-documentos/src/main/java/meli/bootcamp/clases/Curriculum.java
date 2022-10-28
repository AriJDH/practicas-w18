package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Impresable;

import java.util.ArrayList;

public class Curriculum implements Impresable {
    private Persona persona;
    private ArrayList<String> habilidades;


    @Override
    public void imprimirDocumento() {
        System.out.println("Documento impreso");
    }
}
