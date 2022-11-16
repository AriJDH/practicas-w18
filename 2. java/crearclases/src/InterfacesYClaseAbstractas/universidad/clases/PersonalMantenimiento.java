package InterfacesYClaseAbstractas.universidad.clases;

public class PersonalMantenimiento extends MiembrosDelPersonal{

    public PersonalMantenimiento(
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
}
