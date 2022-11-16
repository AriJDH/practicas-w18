package InterfacesYClaseAbstractas.universidad.clases;

public class Estudiante extends Persona{

    private int legajoEstudiante;
    public Estudiante(
            String nombre,
            String apellido,
            Integer dni,
            String dirección,
            String localidad,
            String provincia,
            String pais,
            int legajoEstudiante
    ) {
        super(
                nombre,
                apellido,
                dni,
                dirección,
                localidad,
                provincia,
                pais
        );
        this.legajoEstudiante = legajoEstudiante;
    }
}
