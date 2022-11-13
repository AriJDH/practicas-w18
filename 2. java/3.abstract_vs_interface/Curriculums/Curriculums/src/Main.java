import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Libros libro = new Libros(20,"Sofia", "Aprendiendo java", "informatica");
        Informes informes = new Informes("djksaljdksal", "Sofia monasterio", "Pablo Cuezzo", 50);

        List<String> atributos = new ArrayList<>();
        atributos.add("proactiva");
        atributos.add("responsable");
        Curriculum curriculum = new Curriculum("Sofia", "Monasterio", atributos);

        libro.imprimir();
        informes.imprimir();
        curriculum.imprimir();
    }
}