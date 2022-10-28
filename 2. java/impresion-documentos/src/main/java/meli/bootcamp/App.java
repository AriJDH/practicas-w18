package meli.bootcamp;

import meli.bootcamp.clases.Curriculum;
import meli.bootcamp.clases.Informe;
import meli.bootcamp.clases.Libro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Curriculum c = new Curriculum();
        Libro l = new Libro();
        Informe i = new Informe();

        c.imprimirDocumento();
        l.imprimirDocumento();
        i.imprimirDocumento();
    }
}
