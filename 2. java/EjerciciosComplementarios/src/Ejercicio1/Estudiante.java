package Ejercicio1;

public class Estudiante extends Persona {

    protected String legajo;

    public Estudiante(String nombre,
                      String apellido,
                      Integer dni,
                      String legajo) {
        super(nombre, apellido, dni);
        this.legajo = legajo;
    }

    @Override
    public void anunciarse() {

        System.out.println("Soy un estudiante");
    }

    public void estudiar() {
        System.out.println("Estoy estudiando");
    }
}
