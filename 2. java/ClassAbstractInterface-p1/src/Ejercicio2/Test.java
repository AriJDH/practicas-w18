package Ejercicio2;

import Ejercicio2.Interface.Printable;
import Ejercicio2.modal.BookPDF;
import Ejercicio2.modal.Curriculum;
import Ejercicio2.modal.Person;
import Ejercicio2.modal.Report;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        BookPDF bookPDF=new BookPDF(1000,"Julian","cleanCode");
        List skills=new ArrayList();
        skills.add("Java");
        skills.add("SQL");
        skills.add("Scrum");
        Curriculum curriculum=new Curriculum(new Person("Pablo","Picasso",250),
                skills);

        Report report=new Report("Reportando","Josefina","Carla",12);

        System.out.println("printing documents...");
        Printable.printDocument(bookPDF);
        System.out.println("******************");
        Printable.printDocument(curriculum);
        System.out.println("******************");
        Printable.printDocument(report);
        System.out.println("******************");
    }
}
