package clase3_a_ClasesAbsEInterfaces.Ejercicio2;

public class LibroPdf implements Imprimible{

    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public void imprimir() {
        System.out.println("El libro '" + this.titulo + "' del autor " + this.autor + " es del género " + this.genero + " y tiene " + this.cantPaginas + " páginas");
    }

}
