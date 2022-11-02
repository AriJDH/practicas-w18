import Clases.*;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Morales", "Martin", 28);
        EstudianteTecnico tecnico1 = new EstudianteTecnico("Garcia","Gabriel",30);
        Profesor profesor1 = new Profesor("Basso","Eduardo",46);
        PersonalMantenimiento mantenimiento1 = new PersonalMantenimiento("Quinteros", "Adrian", 34);
        PersonalSoporteTecnico soporteTecnico = new PersonalSoporteTecnico("Suarez", "Andres", 30);
        Tutor tutor1 = new Tutor("Mendez","Carlos",25);

        System.out.println("Tutor: ");
        tutor1.brindarClase();

        System.out.println("Profesor: ");
        profesor1.brindarClase();

        System.out.println("Tecnico: ");
        tecnico1.brindarSoporteTecnico();
    }
}
