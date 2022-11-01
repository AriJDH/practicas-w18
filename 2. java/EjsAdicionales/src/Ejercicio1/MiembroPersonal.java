package Ejercicio1;

public abstract class MiembroPersonal extends Persona {
    private int idPersonal;
    private String nombre;

    public MiembroPersonal(String nombre, int idPersonal) {
        super(nombre);
        this.idPersonal = idPersonal;
    }

    public abstract void cobrarSueldo();
}
