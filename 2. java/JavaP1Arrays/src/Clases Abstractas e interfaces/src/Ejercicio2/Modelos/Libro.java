package Ejercicio2.Modelos;

public class Libro {
    int CantidadDePaginas;
    String NombreDelAutor;
    String Titulo;

    @Override
    public String toString() {
        return "Libro{" +
                "Cantidad de páginas=" + CantidadDePaginas +
                ", Nombre del autor='" + NombreDelAutor + '\'' +
                ", Título='" + Titulo + '\'' +
                ", Género='" + Genero + '\'' +
                '}';
    }

    public int getCantidadDePaginas() {
        return CantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        CantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDelAutor() {
        return NombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        NombreDelAutor = nombreDelAutor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    String Genero;

}
