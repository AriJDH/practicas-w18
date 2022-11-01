package Ejercicio2.Clases;

import Ejercicio2.Modelos.Habilidades;
import Ejercicio2.Modelos.Informe;
import Ejercicio2.Modelos.Libro;
import Ejercicio2.Modelos.Persona;

public class Main {
    public static void main(String[] args) {

        //region Curriculum
        Persona persona1 = new Persona();
        persona1.setNombre("Critiano Ronaldo");
        persona1.setEdad(33);
        Habilidades habilidades = new Habilidades();
        habilidades.setHabilidadesDuras(" ..... ");
        habilidades.setHabilidadesBlandas(" . . . ");
        persona1.setHabilidades(habilidades);

        Curriculums imprimirCurriculum = new Curriculums(persona1);
        //endregion

        //region Informe
        Informe informe = new Informe();
        informe.setAutor("Ch7");
        informe.setTexto("Bla bla bla");
        informe.setCantidadPaginas(25);
        informe.setRevisor("Yo");

        Informes informes = new Informes(informe);
        //endregion

        //region Libros
        Libro libro = new Libro();
        libro.setGenero("Suspenso");
        libro.setTitulo("Crimen y castigo");
        libro.setCantidadDePaginas(700);
        libro.setNombreDelAutor("Fedor Dostoievski");

        LibrosEnPdf librosEnPdf = new LibrosEnPdf(libro);
        //endregion

        //region Forma 1
        Imprimible imprimible = new Imprimible();
        imprimible.imprimir(informes);
        Imprimible imprimible2 = new Imprimible();
        imprimible2.imprimir(librosEnPdf);
        Imprimible imprimible3 = new Imprimible();
        imprimible3.imprimir(imprimirCurriculum);
        //endregion

        //region Forma 2
        Imprimible imprimible4 = new Imprimible();
        imprimible4.setInformes(informes);
        imprimible4.setLibrosEnPdf(librosEnPdf);
        imprimible4.setCurriculums(imprimirCurriculum);
        imprimible4.imprimir();
        //endregion



    }
}
