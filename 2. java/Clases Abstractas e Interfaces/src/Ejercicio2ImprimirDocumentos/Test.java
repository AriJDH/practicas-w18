package Ejercicio2ImprimirDocumentos;

import Ejercicio2ImprimirDocumentos.Documentos.Curriculum;
import Ejercicio2ImprimirDocumentos.Documentos.Informe;
import Ejercicio2ImprimirDocumentos.Documentos.LibroEnPDF;
import Ejercicio2ImprimirDocumentos.Documentos.Persona;
import Ejercicio2ImprimirDocumentos.Impresora.InterfazImprimible;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> habilidadesAgus= new ArrayList<>();
        habilidadesAgus.add("Biologa Moolecular");
        habilidadesAgus.add("Programadora");
        habilidadesAgus.add("Maestrando de MEED");
        Persona agustina= new Persona("Orozco Agustina", habilidadesAgus);
        Curriculum cvAgus = new Curriculum(agustina);

        InterfazImprimible.imprimir(cvAgus);

        Informe informe1= new Informe(250, "Perez", "Un texto muy largo", "Suarez");
        InterfazImprimible.imprimir(informe1);

        LibroEnPDF libro1= new LibroEnPDF(500, "Suarez", "Leyendo a Perez", "Comedia");
        InterfazImprimible.imprimir(libro1);
    }
}
