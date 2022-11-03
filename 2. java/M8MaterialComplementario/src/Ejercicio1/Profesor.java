package Ejercicio1;

public class Profesor extends Personal implements IEnsenianza {

    private String cursoAsignado;

    public Profesor(String nombre,
                    String apellido,
                    Integer dni,
                    String codigoInterno,
                    String cursoAsignado) {
        super(nombre, apellido, dni, codigoInterno);
        this.cursoAsignado = cursoAsignado;
    }

    @Override
    public void enseniar() {
        System.out.println("Estoy dando clases de " + this.cursoAsignado);
    }
}
