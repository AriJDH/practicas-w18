package Ejercicio1;

public class PersonalSoporte extends MiembroPersonal implements Tecnico {
    private String nombre;
    private int idPersonal;

    public PersonalSoporte(String nombre, int idPersonal){
        super(nombre, idPersonal);
    }
    @Override
    public void pedirVacaciones() {
        System.out.println("Se asignan 2 meses de vacaciones");
    }

    @Override
    public void cobrarSueldo() {
        System.out.println("Cobrar sueldo Personal de Soporte");
    }

    @Override
    public void realizarCapacitacion() {
        System.out.println("Capacitacion de personal de soporte");
    }
}
