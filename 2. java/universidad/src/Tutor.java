public class Tutor extends Estudiante{

    public Tutor(int dni, String apellido, String nombre) {
        super(dni, apellido, nombre);
    }

    @Override
    public void actividad() {
        System.out.println("Soy un estudiante que cumple el rol de Tutor");
    }
}
