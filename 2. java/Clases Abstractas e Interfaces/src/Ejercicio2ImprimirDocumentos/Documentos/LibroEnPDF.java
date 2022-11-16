package Ejercicio2ImprimirDocumentos.Documentos;

public class LibroEnPDF extends Documento{
    private String titulo;
    private  String genero;

    public LibroEnPDF(int cantPaginas, String autor, String titulo, String genero) {
        super(cantPaginas, autor);
        this.titulo = titulo;
        this.genero = genero;
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

    @Override
    public String toString() {
        return "LibroEnPDF{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='"+ getAutor()+ '\''+
                ", cantidad de páginas='"+ getCantPaginas()+'\''+
                '}';
    }
}
