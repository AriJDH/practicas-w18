package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Imprimible> lista = new ArrayList<>();
        Curriculum curriculum = new Curriculum("Joaquina", 27, "Programadora", "Java");
        Libro libro = new Libro("Huxley", "Un mundo feliz", "Ciencia Ficcion", 300);
        Informe informe = new Informe("Algun texto", 100, "Desconocido", "Diario");

        lista.add(curriculum);
        lista.add(libro);
        lista.add(informe);

        for(Imprimible reg: lista){
            Imprimible.imprimir(reg);
            System.out.println("------------------");
        }
    }
}
