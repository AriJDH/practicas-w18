package InterfacesYClaseAbstractas.documentos.clases;

import InterfacesYClaseAbstractas.documentos.interfaces.Imprimible;

public class Documentos{
    public static void main(String[] args) {
        Documento libro = new LibrosPDF(10,"yo", "muriendo con JAVA", "realidad" );
        Documento informe = new Informes("un texto de longitud n", 5, "un autor", "alguien que debería revisar");
        Imprimible.print(informe);
    }

}
