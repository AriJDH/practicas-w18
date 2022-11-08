import Class.*;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Ariel", "Cometto", "40974019",
                "ariel.cometto@mercadolibre.com");
        persona1.agregarHabilidad("Java Jr.");
        persona1.agregarHabilidad("Consultor SS");
        Curriculum cv1 = new Curriculum("07/11/2022", persona1 );
        cv1.imprimir();

        Informe informe1 = new Informe(384,1000,"Deitel&Deitel","Tomas");
        informe1.imprimir();

        LibroPDF librito = new LibroPDF(1024,"Desing Patterns","Los 4 amigos locos",
                "IT/Systems");
        librito.imprimir();
    }

}