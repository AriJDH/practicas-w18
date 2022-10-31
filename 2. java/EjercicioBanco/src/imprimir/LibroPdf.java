package imprimir;

public class LibroPdf implements Imprimir{
    private String autor;
    private String titulo;
    private String genero;
    private Integer numeroDePaginas;

    public LibroPdf(String autor, String titulo, String genero, Integer numeroDePaginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.numeroDePaginas = numeroDePaginas;
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

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                '}';
    }
}
