package Ejercicio2;

public class Libro implements Imprimible {
    private String autor;
    private String titulo;
    private String genero;
    private int cantPaginas;

    public Libro(String autor, String titulo, String genero, int cantPaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    @Override
    public void imprimirDocumentos() {
        System.out.println("Autor: " +  this.autor);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Genero: " + this.genero);
        System.out.println("Cantidad de paginas: " + this.cantPaginas);
    }


}
