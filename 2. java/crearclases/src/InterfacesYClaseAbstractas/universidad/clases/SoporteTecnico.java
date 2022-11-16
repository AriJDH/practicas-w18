package InterfacesYClaseAbstractas.universidad.clases;

import InterfacesYClaseAbstractas.universidad.interfaces.PersonalTecnico;

public class SoporteTecnico extends MiembrosDelPersonal implements PersonalTecnico {
    public SoporteTecnico(
            String nombre,
            String apellido,
            Integer dni,
            String dirección,
            String localidad,
            String provincia,
            String pais,
            Integer cuil
    ) {
        super(
                nombre,
                apellido,
                dni,
                dirección,
                localidad,
                provincia,
                pais,
                cuil
        );
    }

    @Override
    public void asignarArea() {

    }
}
