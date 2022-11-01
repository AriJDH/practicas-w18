package ClasesAbstractas_e_Interfaces.Ejercicio2;

import ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos.Curriculum;
import ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos.Documento;
import ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos.Informe;
import ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos.LibroPDF;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<String>();
        lista.add("Estudiante de ingeniería");
        lista.add("Tester");
        lista.add("Proactivo");
        lista.add("Dedicado");
        Documento d1 = new Curriculum("4.763.226-8", 25, "Agustin", lista);
        Documento d2 = new LibroPDF(16, "Pepe", "El aventurero Pepe", "Romance");
        Documento d3 = new Informe("Lorem ipsum Lorem ipsum",5000,"Pepe","Axel");
        IImprimible.imprimir(d1);
        IImprimible.imprimir(d2);
        IImprimible.imprimir(d3);
    }
}
