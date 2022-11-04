package Impresora.Clases;

import Impresora.Interfaces.IImprimir;

public class Imprimible {
    public static void imprimir(Object objeto){
        if (objeto != null && objeto instanceof Curriculums) {
            System.out.println("Imprimiendo curriculum ...");
        }else{
            if (objeto != null && objeto instanceof Informes) {
                System.out.println("Imprimiendo informe ...");
            }else{
                if (objeto != null && objeto instanceof LibrosEnPdf) {
                    System.out.println("Imprimiendo libro en formato PDF ...");
                }
            }
        }
        ((IImprimir<Object>) objeto).imprimir();
    }
}