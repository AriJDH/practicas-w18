package ejercicio2_Imprimir;

import ejercicio2_Imprimir.Interfaz.Printable;
import ejercicio2_Imprimir.Model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Skill> skillList = new ArrayList<>();
        Skill h1 = new Skill("Proactividad");
        Skill h2 = new Skill("Comuncación Asertiva");
        Skill h3 = new Skill("Curiosidad");
        Skill h4 = new Skill("Análitica");
        skillList.add(h1);
        skillList.add(h2);
        skillList.add(h3);
        skillList.add(h4);

        Curriculum cv = new Curriculum(
                new Person("Ivanna", "Cingolani", 39, "29000123"),
                skillList);


        BookPDF libroPDF = new BookPDF(100, "Jorge Luis Borges", "El libro de Arena", "Cuento");

        Report report = new Report(2500, 5, "Tana", "Supervisor");



        Printable.print(cv);
        Printable.print(libroPDF);
        Printable.print(report);


    }


}
