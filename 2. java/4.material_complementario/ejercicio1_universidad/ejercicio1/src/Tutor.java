public class Tutor extends Estudiante{
    public Tutor(String nombre, String apellido, Double promedio, String carrera) {
        super(nombre, apellido, promedio, carrera);
    }

    public void soyTutor(){
        System.out.println("Me llamo "+nombre+ ". Soy un tutor y estudiante de la carrera "+carrera+" , con promedio: "+promedio);
    }
}
