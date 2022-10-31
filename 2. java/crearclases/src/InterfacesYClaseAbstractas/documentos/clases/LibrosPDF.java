package InterfacesYClaseAbstractas.documentos.clases;

import InterfacesYClaseAbstractas.documentos.interfaces.Imprimible;

public class LibrosPDF extends Documento implements Imprimible {
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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
    public void imprimir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return  "cantidadPaginas=" + getCantidadPaginas() +
                ", nombreAutor='" + getNombreAutor() + '\'' +
                ", titulo='" + getTitulo() + '\'' +
                ", genero='" + getGenero() + '\'';
    }
}
