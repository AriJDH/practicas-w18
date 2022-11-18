package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class Informe implements Imprimible {
    private int longitud;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int cantidadDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo documento del tipo '"+getClass().getSimpleName()+"'\nAutor: "+this.autor+". Revisor: "+this.revisor+"\nCantidad de palabras: "+this.longitud+". Número de páginas: "+this.cantidadDePaginas);
    }
}
