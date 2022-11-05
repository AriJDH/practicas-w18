package Universidad.Clases;

import Universidad.CAbstracta.Estudiante;
import Universidad.Interfaces.IEstudianteTecnico;

public class EstudianteTecnico extends Estudiante implements IEstudianteTecnico {


    public EstudianteTecnico(String nombre, int edad, String curso, int semestre) {
        super(nombre, edad, curso, semestre);
    }

    @Override
    public void soporte() {
        System.out.println("Apoyo en soporte");
    }
}