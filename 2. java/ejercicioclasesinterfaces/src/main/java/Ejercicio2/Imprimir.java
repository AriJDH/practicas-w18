package Ejercicio2;

import java.util.ArrayList;

public class Imprimir implements Impresora {

    @Override
    public void imprimirCV(Object a, ArrayList b) {
        System.out.println("Datos personales: " + a);
        System.out.println("Lista de habilidades: " +b);
    }

    @Override
    public void imprimirLibroPDF(int cantPag, String autor, String titulo, String genero) {
        System.out.println("Cantidad de paginas: " + cantPag);
        System.out.println("Autor: " + autor);
        System.out.println("Titulo: "+ titulo);
        System.out.println("Género: " + genero);
    }

    @Override
    public void imprimirInforme(String texto, int cantPag, String autor, String revisor) {
        System.out.println("Informe:" + texto);
        System.out.println("Cantidad de paginas: " + cantPag);
        System.out.println("Autor: "+ autor);
        System.out.println("Revisor: " + revisor);
    }
}
