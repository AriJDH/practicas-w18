package ejercicio4_comp_Universidad.Util;

import ejercicio4_comp_Universidad.Intefaz.FuncionDocencia;
import ejercicio4_comp_Universidad.Intefaz.FuncionSoporteTecnico;
import ejercicio4_comp_Universidad.Model.*;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static void mostrarPersonal(List<Persona> personal) {

        for (Persona p : personal) {
            System.out.println(p);
            if (p instanceof Tecnico || p instanceof SoporteTecnico) {
                ((FuncionSoporteTecnico) p).darSoporteTecnico();
            }

            if (p instanceof Tutor || p instanceof Docente) {
                ((FuncionDocencia) p).darTutoria();
            }
            System.out.println(" ---- ");
        }
    }

    public static void mostrarPersonalStream(List<Persona> personal) {

        System.out.println("*** Funciones de Soporte Técnico ***");
        List<Persona> funcionSoporteTecnico =
                personal.stream()
                        .filter(p -> p instanceof FuncionSoporteTecnico)
                        .collect(Collectors.toList());

        funcionSoporteTecnico.forEach(System.out::println);




        System.out.println("*** Funciones de Docencia ***");
        List<Persona> funcionDocencia =
                personal.stream()
                        .filter(FuncionDocencia.class::isInstance)
                        .collect(Collectors.toList());


        funcionDocencia.forEach(System.out::println);


    }
}
