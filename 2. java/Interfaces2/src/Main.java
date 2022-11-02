import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <String> hab= new ArrayList<String>();
        hab.add("Dev");
        hab.add("QA");
        hab.add("Analista");

        Curriculum cv = new Curriculum("Pepe", 23,23456789,hab);
        LibroPDF libre = new LibroPDF(23,"Juan","Bowie","Laberinto","Fantasia");
        Informe informe = new Informe("Un texto",8,1,"Pepe", "Juan");

        cv.imprimir(cv);
        libre.imprimir(libre);
        informe.imprimir(informe);
    }
}