import impresora.*;

public class App {
    public static void main(String[] args) {
        Documento pdf = new LibroPDF(500, "Pepito Juarez", "Un día en la vida", "Ficción");
        Documento informe = new Informe("Este es un informe muy importante y largo.", 2, "Juanita Valdez", "Juanito Fernandez");
        Documento cv = new Curriculum(new Persona("Mariana", "Madeira", "2/4/92"), "Java", "Spring Boot", "MySql", "Trabajo en equipo");

        Imprimible.imprimirDocumento(pdf);
        System.out.println("*************************************************");
        Imprimible.imprimirDocumento(informe);
        System.out.println("*************************************************");
        Imprimible.imprimirDocumento(cv);
    }
}
