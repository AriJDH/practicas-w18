package Impresora.Models;

public class Informe {
    String Texto;
    int CantidadPaginas;
    String Autor;
    String Revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "Texto='" + Texto + '\'' +
                ", Cantidad de páginas=" + CantidadPaginas +
                ", Autor='" + Autor + '\'' +
                ", Revisor='" + Revisor + '\'' +
                '}';
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public int getCantidadPaginas() {
        return CantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        CantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getRevisor() {
        return Revisor;
    }

    public void setRevisor(String revisor) {
        Revisor = revisor;
    }
}
