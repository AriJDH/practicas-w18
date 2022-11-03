package Main;

import Clases.Curriculums;
import Clases.Persona;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> habilidades= new ArrayList<String>();
        habilidades.add("java");
        habilidades.add("python");
        habilidades.add("SQL");
        habilidades.add("bordar");
        habilidades.add("excel");
        Persona persona1= new Persona("Maria",23,"Developer", 1);
        Curriculums curriculum1 = new Curriculums(persona1,habilidades);

        System.out.println(curriculum1.imprimir());
    }
}
