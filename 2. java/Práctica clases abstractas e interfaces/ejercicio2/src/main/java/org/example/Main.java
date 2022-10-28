package org.example;

import org.example.domain.Curriculum;
import org.example.domain.Imprimible;
import org.example.domain.Informe;
import org.example.domain.LibroPdf;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimible> documentos = new ArrayList<>();
        Curriculum cv = new Curriculum("Marcos");
        cv.addHabilidad("Java");
        cv.addHabilidad("React");
        documentos.add(cv);
        Informe informe = new Informe("Un texto", 10, "Norberto", "Ricardo");
        documentos.add(informe);
        LibroPdf libro = new LibroPdf(900 ,"JK Rowling", "Harry Potter 5", "Fantasía");
        documentos.add(libro);
        documentos.stream().forEach(doc->doc.print());
    }
}