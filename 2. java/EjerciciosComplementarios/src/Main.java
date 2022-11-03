import Ejercicio1.EstudianteTecnico;
import Ejercicio1.Mantenimiento;
import Ejercicio1.Profesor;
import Ejercicio1.Tutor;
import Ejercicio2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(" ========================== Ejercicio 1 ========================== ");

        List<String> reparaciones = new ArrayList<>();
        reparaciones.add("Reparar 1");
        reparaciones.add("Reparar 2");

        List<String> clases = new ArrayList<>();
        clases.add("Clase 1");
        clases.add("Clase 2");

        EstudianteTecnico estudianteTecnico1 = new EstudianteTecnico("Estudiante",
                "Técnico",
                123456,
                "ABC123",
                reparaciones);

        Mantenimiento mantenimiento = new Mantenimiento("Mantenimiento",
                "Apellido",
                123456,
                "123ABC");

        Profesor profesor = new Profesor("Profesor",
                "Apellido",
                123456,
                "123ABCD",
                "Economía");

        Tutor tutor = new Tutor("Tutor",
                "Estudiante",
                123456,
                "ABC1234",
                clases);

        System.out.println("*****************************************************");
        estudianteTecnico1.anunciarse();
        estudianteTecnico1.reparar();
        estudianteTecnico1.estudiar();

        System.out.println("*****************************************************");
        mantenimiento.anunciarse();
        mantenimiento.trabajar();

        System.out.println("*****************************************************");
        profesor.anunciarse();
        profesor.enseniar();
        profesor.trabajar();

        System.out.println("*****************************************************");
        tutor.anunciarse();
        tutor.estudiar();
        tutor.enseniar();
    }
    }