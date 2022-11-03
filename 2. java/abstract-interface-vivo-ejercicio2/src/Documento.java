public abstract class Documento implements Imprimible{
    int cantPaginas;
    String autor;

    public Documento(int cantPaginas, String autor) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
    }
}
