package Ejercicio1;

import Ejercicio1.MiembroPersonal;

public class PersonalMantenimiento extends MiembroPersonal implements Tecnico {
    private String nombre;
    private int idPersonal;

    public PersonalMantenimiento(String nombre, int idPersonal){
        super(nombre, idPersonal);
    }
    @Override
    public void pedirVacaciones() {
        System.out.println("Se asignan 2 meses de vacaciones");
    }

    @Override
    public void cobrarSueldo() {
        System.out.println("Cobrar sueldo personal de mantenimiento");
    }

    @Override
    public void realizarCapacitacion() {
        System.out.println("Capacitacion para personal de mantenimiento");
    }
}
