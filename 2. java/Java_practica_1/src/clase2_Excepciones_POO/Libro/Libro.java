package clase2_Excepciones_POO.Libro;

public class Libro {
    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadDeEjemplares(){
        return this.ejemplares;
    }

    public String mostrarLibro(){
        return "Título: " + this.titulo + " Autor: " + this.autor + " Ejemplares: " + this.ejemplares;
    }
}
