package InterfacesYClaseAbstractas.universidad.clases;

import InterfacesYClaseAbstractas.universidad.interfaces.PersonalDocente;

public class Tutores extends Estudiante implements PersonalDocente {
    public Tutores(
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
                pais,
                legajoEstudiante
        );
    }

    @Override
    public void asignarCurso(String curso) {

    }

    @Override
    public void asignarAlumnos(int... legajo) {

    }
}
