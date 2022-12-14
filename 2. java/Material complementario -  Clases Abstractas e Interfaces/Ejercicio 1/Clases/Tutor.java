public class Tutor extends Estudiante implements EnseñarAlgo{

    public Tutor(String nombre, int edad, String dni){
        super(nombre, edad, dni);
    }

    @Override
    public void enseñar(){
        System.out.println("Listo para enseñar algo ...");
    }

}
