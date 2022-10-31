package ej2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<String>();
        lista.add("Marinero");
        lista.add("Guardia de seguridad");
        lista.add("Proactivo");
        lista.add("Dedicado");
        Documento d1 = new Curriculum("4.763.226-8", 25, "Axel", lista);
        Documento d2 = new LibroEnPdf(16, "Pepe", "El aventurero Pepe", "Romance");
        Documento d3 = new Informe("Lorem ipsum Lorem ipsum",5000,"Pepe","Axel");
        Imprimible.imprimir(d1);
        Imprimible.imprimir(d2);
        Imprimible.imprimir(d3);
    }
}

