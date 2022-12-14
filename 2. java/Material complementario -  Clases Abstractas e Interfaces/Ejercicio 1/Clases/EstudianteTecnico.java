public class EstudianteTecnico extends Estudiante implements ColaborarEnSoporteTecnico{

    public EstudianteTecnico(String nombre, int edad, String dni){
        super(nombre, edad, dni);
    }

    @Override
    public void colaborar(){
        System.out.println("Listo para colaborar en soporte tecnico ...");
    }

}
