package ejercicio2;

public class LibroPDF extends Libro{
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, Persona autor, String titulo, String genero) {
        super(cantidadPaginas, autor);
        this.titulo=titulo;
        this.genero=genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String imprimirContenido() {
        return super.imprimirContenido()+" Titulo: "+titulo+", Genero: "+genero;
    }
}
