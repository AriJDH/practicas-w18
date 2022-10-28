package practica_abstracta_interfaces_vivo.ejercicio2.clases;

import practica_abstracta_interfaces_vivo.ejercicio2.interfaces.IImpresion;

public class Main {
    public static void main(String[] args) {
        IImpresion impresion = new Curriculum();

        impresion.imprimirDocumento("Curriculum");

        impresion = new Informe();

        impresion.imprimirDocumento("Informe");

        impresion = new LibroPDF();

        impresion.imprimirDocumento("Libro en pdf");
    }
}
