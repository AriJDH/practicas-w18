public class Libro extends Documento{
    String titulo;
    String genero;

    public Libro(int cantPaginas, String autor, String titulo, String genero) {
        super(cantPaginas, autor);
        this.titulo = titulo;
        this.genero = genero;
    }
}
