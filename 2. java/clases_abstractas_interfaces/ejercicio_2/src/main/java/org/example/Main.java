package org.example;

import org.example.models.Curriculum;
import org.example.models.Informe;
import org.example.models.Libro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> skills = new ArrayList<>();
        skills.add("JAVA");
        skills.add("JavaScript");
        skills.add("Python");
        skills.add("SQL");
        skills.add("NoSQL");

        Curriculum cv = new Curriculum("Federico","Paz",26,skills);

        Libro libro1 = new Libro("J. K. Rowling","Harry Potter", "Ficción", 700);

        Informe informe = new Informe("Mario Benedetti",500,"Bianca Rivara","Poemas de muy buena calidad y expresión.");

        System.out.println("Printing Curriculums...");
        System.out.println(cv);
        System.out.println("\nPrinting Libros");
        System.out.println(libro1);
        System.out.println("\nPrinting Informes");
        System.out.println(informe);

    }
}