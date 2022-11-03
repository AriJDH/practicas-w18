package Ejercicio1;

import java.util.List;

public class EstudianteTecnico extends Estudiante implements IReparacion{


    private List<String> listaReparaciones;

    public EstudianteTecnico(String nombre,
                             String apellido,
                             Integer dni,
                             String legajo,
                             List<String> listaReparaciones) {
        super(nombre, apellido, dni, legajo);
        this.listaReparaciones = listaReparaciones;
    }

    @Override
    public void anunciarse() {

        System.out.println("Soy un Estudiante Técnico");
    }

    public void reparar() {
        System.out.println("Tengo para reparar la siguiente lista: " + this.listaReparaciones);
    }

}
