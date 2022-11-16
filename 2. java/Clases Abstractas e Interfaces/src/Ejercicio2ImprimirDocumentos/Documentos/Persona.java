package Ejercicio2ImprimirDocumentos.Documentos;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private ArrayList<String> habilidades = new ArrayList<>();

    public Persona(String nombre, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        String strHabilidades= String.join(", ", habilidades);
        return " Mi nombre es " + nombre + " y mis habilidades son: " + strHabilidades;
    }
}
