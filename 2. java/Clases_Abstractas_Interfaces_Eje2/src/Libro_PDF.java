public class Libro_PDF implements Imprimible{

    private int cant_Pags;
    private String autor;
    private String titulo;
    private String genero;

    public Libro_PDF(int cant_Pags, String autor, String titulo, String genero) {
        this.cant_Pags = cant_Pags;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Libro_PDF{" +
                "cant_Pags=" + cant_Pags +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
