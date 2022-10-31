package clase3_a_ClasesAbsEInterfaces.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Ingles");
        habilidades.add("Java");
        habilidades.add("SQL");

        Curriculum cv = new Curriculum("Seba", "Gines", habilidades);
        cv.imprimir();
        LibroPdf libro = new LibroPdf(456, "Tolkien", "El señor de los anillos", "Ciencia Ficción");
        libro.imprimir();
    }
}
