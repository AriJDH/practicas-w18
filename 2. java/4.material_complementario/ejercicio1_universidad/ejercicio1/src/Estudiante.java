
public abstract class Estudiante extends Persona{
    Double promedio;
    String carrera;

    public Estudiante(String nombre, String apellido, Double promedio, String carrera) {
        super(nombre, apellido);
        this.promedio = promedio;
        this.carrera = carrera;
    }
}
