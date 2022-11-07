package ejercicio_4_administracion_cursos;

public class Estudiante implements Personal{

    @Override
    public void imprimirNombre() {
        System.out.println(getClass().getSimpleName());
    }

}
