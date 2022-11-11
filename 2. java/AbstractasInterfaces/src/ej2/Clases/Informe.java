package ej2.Clases;

public class Informe implements Imprimible{
    private String autor, revisor, main, titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private int cantidadDePaginas;

    public Informe(String autor, String revisor, String main, int cantidadDePaginas, String titulo) {
        this.autor = autor;
        this.revisor = revisor;
        this.main = main;
        this.cantidadDePaginas = cantidadDePaginas;
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
        System.out.println("Titulo:" + titulo);
        System.out.println("by: " + autor + " edited by: " + revisor);
        System.out.println(cantidadDePaginas + " paginas");
        System.out.println(main);
    }
}
