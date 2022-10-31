package banco;

import animales.Gato;
import animales.Perro;
import animales.Vaca;
import imprimir.Curriculum;
import imprimir.Imprimir;
import imprimir.Informes;
import imprimir.LibroPdf;

public class Main {

    public static void main(String[] args) {

     // Ejercicio 1

        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();


        basic.transaccionOK();
        basic.transaccionNoOk();

        cobrador.transaccionOK();
        cobrador.transaccionNoOk();

        ejecutivo.transaccionOK();
        ejecutivo.transaccionNoOk();


    // Ejercicio 2

        Curriculum curriculum = new Curriculum("Martin", "Perez", 34256729,"jmartin.perez@mercadolibre.com");
        Informes informes = new Informes(100,"Martin", "Perez", "Lorem");
        LibroPdf libroPdf = new LibroPdf("Martin", "Aprendiendo Java", "Informatico", 400);

        Imprimir.print(curriculum);

        Imprimir.print(informes);

        Imprimir.print(libroPdf);


    // Ejercicio 3

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        perro.comerAnimal(perro);
        gato.comerAnimal(gato);
        vaca.comerAnimal(vaca);
    }
}
