package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private List<Habilidad> habilidades;

    public Curriculum(String nombre, String apellido, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo documento del tipo '"+getClass().getSimpleName()+"'\nPertenece a "+this.nombre+" "+this.apellido+"\nSus habilidades son: "+this.habilidades);
    }
}
