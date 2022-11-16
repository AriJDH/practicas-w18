package InterfacesYClaseAbstractas.universidad.clases;

import InterfacesYClaseAbstractas.universidad.interfaces.PersonalDocente;

public class Profesores extends MiembrosDelPersonal implements PersonalDocente {

    private long cuit;
    private int numeroLegajo;
    private String[] asignaturas;

    public Profesores(
            String nombre,
            String apellido,
            Integer dni,
            String dirección,
            String localidad,
            String provincia,
            String pais,
            Integer cuil,
            int numeroLegajo,
            String... asignaturas
    ) {
        super(nombre, apellido, dni, dirección, localidad, provincia, pais, cuil);

        this.numeroLegajo = numeroLegajo;
        this.asignaturas = asignaturas;
    }

    @Override
    public void asignarCurso(String curso) {

    }

    @Override
    public void asignarAlumnos(int... legajo) {

    }
}
