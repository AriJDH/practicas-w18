package Ejercicio1;

public class Estudiante extends Persona {

    private String nombre;

    public Estudiante(String nombre){
        super(nombre);
    }
    @Override
    public void pedirVacaciones() {
        System.out.println("Se asignan 3 meses de vacaciones");
    }
}