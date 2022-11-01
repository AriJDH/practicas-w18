package Ejercicio1;

public class EstudianteTecnico extends Estudiante implements Tecnico {
    private String nombre;
    private String campoDeTrabajo;

    public EstudianteTecnico(String nombre, String campoDeTrabajo){
        super(nombre);
        this.campoDeTrabajo = campoDeTrabajo;
    }
    @Override
    public void pedirVacaciones() {
        System.out.println("Se asignan 3 meses de vacaciones");
    }

    @Override
    public void realizarCapacitacion() {
        System.out.println("Capacitacion de Estudiante Tecnico");
    }
}
