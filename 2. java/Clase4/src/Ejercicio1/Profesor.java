package Ejercicio1;

public class Profesor extends MiembroPersonal implements Docente {
    private String nombre;
    private int idPersonal;

    public Profesor(String nombre, int idPersonal){
        super(nombre, idPersonal);
    }
    @Override
    public void pedirVacaciones() {
        System.out.println("Se asignan dos meses de vacaciones");
    }

    @Override
    public void cobrarSueldo() {
        System.out.println("Cobrar sueldo de profesor");
    }

    @Override
    public void dictarMateria() {
        System.out.println("Materia dictada");
    }
}
