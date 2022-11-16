package InterfacesYClaseAbstractas.universidad.clases;

import InterfacesYClaseAbstractas.universidad.interfaces.PersonalTecnico;

public class EstudianteTecnico
        extends Estudiante implements PersonalTecnico {
    public EstudianteTecnico(
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
    public void asignarArea() {

    }
}
