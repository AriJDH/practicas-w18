public class LibroPDF  implements Imprimible{
    int cantPag;
    String nombre;
    String autor;
    String titulo;
    String genero;

    public LibroPDF(int cantPag, String nombre, String autor, String titulo, String genero) {
        this.cantPag = cantPag;
        this.nombre = nombre;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantPag=" + cantPag +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public int getCantPag() {
        return cantPag;
    }

    public void setCantPag(int cantPag) {
        this.cantPag = cantPag;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
    public void imprimir(Object o) {
        System.out.println(o.toString());
    }
}
