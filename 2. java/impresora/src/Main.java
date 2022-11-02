import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona(37518629, "Macarena","Spalenza", 29);
        List<String> habilidades = Arrays.asList("Proactivo","Responsable","Innovador");
        Curriculum curriculum = new Curriculum(persona,habilidades);

        Pdf pdf = new Pdf(44, "Pepito", "Pepito tomando sol", "Novela");

        Informe informe = new Informe("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...",2,"Honguito","Menganito");

        curriculum.imprimir();
        pdf.imprimir();
        informe.imprimir();

    }
}
