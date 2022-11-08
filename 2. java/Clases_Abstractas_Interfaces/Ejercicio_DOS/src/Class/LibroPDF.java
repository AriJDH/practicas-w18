package Class;

import Interface.Imprimible;

public class LibroPDF implements Imprimible {

    private Integer cantidadPag;
    private String nombreLibro;
    private String autor;
    private String genero;

    public LibroPDF(Integer cantidadPag, String nombreLibro, String autor, String genero) {
        this.cantidadPag = cantidadPag;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.genero = genero;
    }

    public Integer getCantidadPag() {
        return cantidadPag;
    }

    public void setCantidadPag(Integer cantidadPag) {
        this.cantidadPag = cantidadPag;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPag=" + cantidadPag +
                ", nombreLibro='" + nombreLibro + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public void imprimir(){
        System.out.println(this.toString());
    }
}
