public class EstudianteTecnico extends Estudiante{

    public EstudianteTecnico(int dni, String apellido, String nombre) {
        super(dni, apellido, nombre);
    }

    @Override
    public void actividad() {
        System.out.println("Soy un estudiante que cumple el rol de Técnico");
    }
}
