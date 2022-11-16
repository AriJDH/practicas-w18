package Ejercicio2ImprimirDocumentos.Documentos;

public class Documento {
    private int cantPaginas;
    private String autor;

    public Documento() {
    }

    public Documento(int cantPaginas, String autor) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "cantPaginas=" + cantPaginas +
                ", autor='" + autor + '\'' +
                '}';
    }
}
