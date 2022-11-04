package Ejercicio1.Clases;

import Ejercicio1.CAbstracta.Estudiante;
import Ejercicio1.Interfaces.ITutor;

public class Tutor extends Estudiante implements ITutor {

    public Tutor(String nombre, int edad, String curso, int semestre) {
        super(nombre, edad, curso, semestre);
    }

    @Override
    public void tutoria() {
        System.out.println("Soy un tutor");
    }
}
