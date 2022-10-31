package practica_complementario_clase_abstracta.ejercicio1;

public class EstudianteTecnico extends Estudiante implements IAccionesSoporte {

    @Override
    public void realizarSoporteTecnico() {
        //realizar soporte
    }

    @Override
    public void registrarMaterias(Estudiante estudiante) {

        //Se puede regitrar de manera especial para el tecnico
        super.registrarMaterias(estudiante);
    }
}
