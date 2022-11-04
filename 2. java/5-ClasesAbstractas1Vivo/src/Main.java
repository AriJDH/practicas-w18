import ejercicio1.Basic;
import ejercicio1.Cobrador;
import ejercicio1.Ejecutivo;
import ejercicio2.Curriculum;
import ejercicio2.PdfBook;
import ejercicio2.Printable;
import ejercicio2.Report;
import ejercicio3.Gato;
import ejercicio3.Perro;
import ejercicio3.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Ejercio 1
        System.out.println(" ------------------ Ejercicio 1 --------------------- ");

        // Clientes
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        // Uso de las interfaces
        ejecutivo.transaccionOk();
        cobrador.transaccionNoOk();
        basic.transaccionOk();


        // ------------------------------------------------------------------------------ //
        // Ejercicio 2
        System.out.println(" ------------------ Ejercicio 2 --------------------- ");

        // Construimos un curriculum de ejemplo
        List<String> listaHabilidades = new ArrayList<>();
        listaHabilidades.add("Habilidad1");
        listaHabilidades.add("Habilidad2");
        Curriculum curriculum = new Curriculum("Nombre",
                "Apellido",
                123,
                "Domicilio",
                listaHabilidades);

        // Imprimimos el Curriculum.
       Printable.print(curriculum);

       // Construimos un PdfBook de ejemplo.
        PdfBook pdfBook = new PdfBook(10,
                "AutorX",
                "titulo1",
                "Genero1" );

        // Imprimimos un PdfBook.
        Printable.print(pdfBook);

        // Construimos un Report
        Report report = new Report("Text",
                10,
                "Autor1",
                "Revisor");

        // Imprimimos un reporte
        Printable.print(report);

        // ------------------------------------------------------------------------------ //
        // Ejercicio 3
        System.out.println(" ------------------ Ejercicio 3 --------------------- ");

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        perro.comerCarne();
        perro.comerAnimal(perro);
        gato.emitirSonido();
        gato.comerCarne();
        gato.comerAnimal(perro);
        vaca.emitirSonido();
        vaca.comerHierba();
        vaca.comerAnimal(gato);
    }
}