package ej2.Clases;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        PDF pdf = new PDF(150, "Isaac Asimov", "El Problema de los Tres Cuerpos", "Sci-Fi");

        ArrayList<String> list = new ArrayList<>();
        list.add("Python");
        list.add("Java");
        list.add("Git");
        CV cv = new CV("Gonzalo", "Galfre", "Argentino", 21, list);

        Informe informe = new Informe("Gonzalo Galfre", "Pedro De La Fuente", "lorem", 53, "Tesis");



        pdf.imprimir();
        System.out.println("---------------------");
        cv.imprimir();
        System.out.println("---------------------");
        informe.imprimir();
    }
}
