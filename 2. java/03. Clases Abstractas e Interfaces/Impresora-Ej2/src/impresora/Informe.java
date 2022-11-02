package impresora;

public class Informe extends Documento implements Imprimible{
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(this.texto);
        System.out.println("Páginas: "+ this.cantPaginas);
        System.out.println("Autor: "+ this.autor);
        System.out.println("Revisor: "+ this.revisor);
    }
}
