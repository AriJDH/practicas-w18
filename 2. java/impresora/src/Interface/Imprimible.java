package Interface;

import superclase.Archivo;

public interface Imprimible  {

    public static void imprimir(Archivo archivo) {

        System.out.println("El " + archivo + " se está imprimiendo");

    }

}
