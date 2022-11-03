package ejercicio4_comp_Universidad;

import ejercicio4_comp_Universidad.Model.*;
import ejercicio4_comp_Universidad.Util.Util;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Persona admin = new Administrativo("Juan");
        Persona docente = new Docente("Mariana");
        Persona mantenimiento = new Mantenimiento("Roxanna");
        Persona soporteTecnico = new SoporteTecnico("Ulises");
        Persona estudiante = new Estudiante("Javiera");
        Persona estudianteTecnico = new Tecnico("Tana");
        Persona estudianteTutor = new Tutor("Mariela");


        List<Persona> personal = List.of(
                admin,
                docente,
                mantenimiento,
                soporteTecnico,
                estudiante,
                estudianteTecnico,
                estudianteTutor);

        //Método tradicional
        Util.mostrarPersonal(personal);


        //Con Lambda
        Util.mostrarPersonalStream(personal);




    }

}
