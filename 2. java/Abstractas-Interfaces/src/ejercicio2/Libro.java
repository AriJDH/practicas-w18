package ejercicio2;

public abstract class Libro implements Documento {
    int cantidadPaginas;
    Persona autor;

    public Libro(int cantidadPaginas, Persona autor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }
    public String imprimirContenido(){
        return "Autor: "+autor.toString()+" Cantidad de paginas: "+cantidadPaginas;
    }
}
