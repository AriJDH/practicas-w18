public class LibrosPDF implements Impresora{

    private int cantidadDePaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadDePaginas, String autor, String titulo, String genero){
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public String toString(){
        return "Libro en formato PDF" + "\n" +
                "Cantidad de paginas: " + this.cantidadDePaginas + "\n" +
                "Autor: " + this.autor + "\n" +
                "Titulo: " + this.titulo + "\n" +
                "Genero: " + this.genero;
    }



}
