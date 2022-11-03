package Ejercicio1;

import java.util.List;

public class SoporteTecnico extends Personal implements IReparacion{

    private List<String> listaReparaciones;

    public SoporteTecnico(String nombre,
                          String apellido,
                          Integer dni,
                          String codigoInterno,
                          List<String> listaReparaciones) {
        super(nombre, apellido, dni, codigoInterno);
        this.listaReparaciones = listaReparaciones;
    }


    @Override
    public void reparar() {

        System.out.println("Tengo para reparar " + this.listaReparaciones);
    }
}
