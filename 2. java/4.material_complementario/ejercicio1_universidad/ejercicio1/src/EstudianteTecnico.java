public class EstudianteTecnico extends Estudiante{
    public EstudianteTecnico(String nombre, String apellido, Double promedio, String carrera) {
        super(nombre, apellido, promedio, carrera);
    }

    public void soyEstudianteTecnico(){
        System.out.println("Me llamo "+nombre+ ". Estoy en soporte técnico" +
                " y estudiante de la carrera "+carrera+" , con promedio: "+promedio);

    }
}
