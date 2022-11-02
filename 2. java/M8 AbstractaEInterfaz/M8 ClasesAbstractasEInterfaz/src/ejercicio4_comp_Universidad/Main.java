package ejercicio4_comp_Universidad;

import ejercicio4_comp_Universidad.Model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona admin = new Administrativo("Juan");
        Persona docente = new Docente("Mariana");
        Persona mantenimiento = new Mantenimiento("Roxanna");
        Persona soporteTecnico = new SoporteTecnico("Ulises");
        Persona estudiante = new Estudiante("Javiera");
        Persona estudianteTecnico = new Tecnico("Tana");
        Persona estudianteTutor = new Docencia("Mariela");

        ArrayList<Persona> personal = new ArrayList<>();

        personal.add(admin);
        personal.add(docente);
        personal.add(mantenimiento);
        personal.add(soporteTecnico);
        personal.add(estudiante);
        personal.add(estudianteTecnico);
        personal.add(estudianteTutor);


        for (Persona p: personal) {
            System.out.println(p);
            if(p instanceof Tecnico){
                ((Tecnico) p).darSoporteTecnico();
            }
            if(p instanceof Docencia){
                ((Docencia) p).darTutoria();
            }
            System.out.println( " ---- ");
        }

    }
}
