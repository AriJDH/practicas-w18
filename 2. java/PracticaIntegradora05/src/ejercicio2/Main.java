package ejercicio2;

import ejercicio2.model.Curriculum;
import ejercicio2.model.Documento;
import ejercicio2.model.Informe;
import ejercicio2.model.LibroPDF;

public class Main {

    public static void main(String[] args) {

        Documento documento = new Curriculum();
        documento.imprimir();

        documento = new LibroPDF();
        documento.imprimir();

        documento = new Informe();
        documento.imprimir();
    }

}
