public class Main {
    public static void main(String[] args) {

        Estudiante estudianteTutor = new Tutor(12,"Pepi", "to");
        Tutor tutor = new Tutor(23, "Mengui", "to");
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico(34, "Hongui", "to");

        estudianteTutor.actividad();
        estudianteTutor.getDni();

        tutor.actividad();
        tutor.getDni();

        estudianteTecnico.actividad();
        estudianteTecnico.getDni();

        Profesor profesor = new Profesor();
        Soporte soporte = new Soporte();
        Mantenimiento mantenimiento = new Mantenimiento();

        profesor.getTareas();
        soporte.getTareas();
        mantenimiento.getTareas();

    }
}
