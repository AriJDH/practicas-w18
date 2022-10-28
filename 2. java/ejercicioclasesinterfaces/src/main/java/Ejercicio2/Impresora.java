package Ejercicio2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface Impresora {
     public void imprimirCV(Object a, ArrayList b);
     public void imprimirLibroPDF(int cantPag, String autor, String titulo, String genero);
     public void imprimirInforme(String texto, int cantPag, String autor, String revisor);
}
