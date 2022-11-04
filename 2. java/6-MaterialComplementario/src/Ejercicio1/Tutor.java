package Ejercicio1;

import java.util.List;

public class Tutor extends Estudiante implements IEnsenianza {

    private List<String> listaClases;

    public Tutor(String nombre,
                 String apellido,
                 Integer dni,
                 String legajo,
                 List<String> listaClases) {
        super(nombre, apellido, dni, legajo);
        this.listaClases = listaClases;
    }

    @Override
    public void enseniar() {
        System.out.println("Estoy enseñando estas clases: " + this.listaClases);
    }
}
