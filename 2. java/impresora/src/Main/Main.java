package Main;

import Interface.Imprimible;
import clases.Curriculum;
import clases.Informe;
import clases.LibroPDF;
import clases.Persona;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        Persona persona = new Persona("Pablo", "4584732",34 );

        persona.agregarHabilidad("Cantar");
        persona.agregarHabilidad("Actuar");
        persona.agregarHabilidad("Bailar");

        System.out.println(persona.getHabilidades());


        LibroPDF libroPDF = new LibroPDF(98, "Verónica Baz", "Inmortales", "Drama");


        Curriculum curriculum = new Curriculum(persona);


        Informe informe = new Informe(72, "Carlos Antonio", "Estrada","blablabla");

        Imprimible.imprimir(curriculum);

        Imprimible.imprimir(informe);

        Imprimible.imprimir(libroPDF);

    }

}
