package Ejercicio2.Clases;

import Ejercicio2.Interfaces.IImprimir;
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

        Main main = new Main();
        main.imprimible(imprimirCurriculum);
        main.imprimible(librosEnPdf);
        main.imprimible(informes);

    }

    public void imprimible(Object objecto){
        if (objecto != null && objecto instanceof Curriculums) {
            System.out.println("Imprimiendo curriculum ...");
        }else{
            if (objecto != null && objecto instanceof Informes) {
                System.out.println("Imprimiendo informe ...");
            }else{
                if (objecto != null && objecto instanceof LibrosEnPdf) {
                    System.out.println("Imprimiendo libro en formato PDF ...");
                }
            }
        }
        ((IImprimir<Object>) objecto).imprimir();
    }
}
