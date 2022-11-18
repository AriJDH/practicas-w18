package ejercicio2;

import ejercicio2.clases.Curriculum;
import ejercicio2.clases.Habilidad;
import ejercicio2.clases.Informe;
import ejercicio2.clases.Libro;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Habilidad habilidad1 = new Habilidad("mediación");
        Habilidad habilidad2 = new Habilidad("comunicación");
        Habilidad habilidad3 = new Habilidad("responsabilidad");

        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(habilidad1);
        habilidades.add(habilidad2);
        habilidades.add(habilidad3);

        Curriculum curriculum = new Curriculum("Gabriela","Ortega",habilidades);
        curriculum.imprimirDocumento();
        System.out.println("-----------------------------------------------------------------------------");

        Libro libro = new Libro(800,"Jorge Luis Borges","El Aleph","Ficción");
        libro.imprimirDocumento();
        System.out.println("-----------------------------------------------------------------------------");

        Informe informe = new Informe(3000,5,"Gabriela Ortega","Lucas Silva Kruse");
        informe.imprimirDocumento();
    }
}
