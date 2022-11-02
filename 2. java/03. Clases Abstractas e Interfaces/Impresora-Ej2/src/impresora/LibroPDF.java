package impresora;

public class LibroPDF extends Documento{
    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Título: "+this.titulo);
        System.out.println("Autor: "+this.autor);
        System.out.println("Género: "+this.genero);
        System.out.println("Páginas: "+this.cantPaginas);
    }
}
