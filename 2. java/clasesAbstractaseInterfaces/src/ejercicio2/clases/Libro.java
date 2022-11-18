package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class Libro implements Imprimible {
    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Libro(int cantidadDePaginas, String autor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo documento del tipo '"+getClass().getSimpleName()+"'\nAutor: "+this.autor+". Título: "+this.titulo+"\nGénero literario: "+this.genero+". Número de páginas: "+this.cantidadDePaginas);
    }
}
