package Ejercicio1Universidad;/*Ejercicio 1
Asuma que queremos modelar personas de una universidad para implementar un sistema de administración de cursos. Hay diferentes personas
involucradas: miembros del personal, estudiantes, profesores, personal de mantenimiento, tutores, personal de soporte técnico y estudiantes
técnicos. Los tutores y los estudiantes técnicos son interesantes: los tutores son estudiantes que han sido elegidos para enseñar algo y los
estudiantes técnicos son estudiantes que han sido seleccionados para colaborar en el soporte técnico. Realice una jerarquía de tipos (clases e
interfaces) que represente esta situación. Reproduce un escenario donde se muestre qué tipos son clases concretas, clases abstractas e interfaces.
*/

import Ejercicio1Universidad.Clases.*;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante1= new Estudiante("Agustina Orozco", 31);
        Profesor profe1= new Profesor("Luis Suarez", 52);
        Soporte personalDeSoporte1= new Soporte("Ana Cararesi", 35);
        Tecnico estudianteTecnico1= new Tecnico("Jose Perez", 25);
        Tutores tutor1 = new Tutores("Elena Gil", 43);

        System.out.println("Mostrando estudiante:");
        System.out.println(estudiante1.toString());

        System.out.println("Profesor: ");
        profe1.darClase();

        System.out.println(" Soporte: ");
        personalDeSoporte1.darSoporteTecnico();

        System.out.println("Estudiante técnico: ");
        estudianteTecnico1.darSoporteTecnico();

        System.out.println("Tutor: ");
        tutor1.darClase();
    }
}