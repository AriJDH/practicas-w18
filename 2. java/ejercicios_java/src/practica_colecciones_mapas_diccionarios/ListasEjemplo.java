package practica_colecciones_mapas_diccionarios;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListasEjemplo {

    private static final String CONSTANTE = "hola";

    public static void main(String[] args) {

        byte entero = (byte) 130;

        System.out.println(entero);

        Vector<String> nombres = new Vector<>();

        CopyOnWriteArrayList<String> apellidos = new CopyOnWriteArrayList<>();

        System.out.println(CONSTANTE);

    }
}