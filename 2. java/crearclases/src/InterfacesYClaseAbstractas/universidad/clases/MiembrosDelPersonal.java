package InterfacesYClaseAbstractas.universidad.clases;

public abstract class MiembrosDelPersonal extends Persona{

    private long cuil;

    public MiembrosDelPersonal(
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
                pais
        );
        this.cuil = cuil;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(Integer cuil) {
        this.cuil = cuil;
    }
}
