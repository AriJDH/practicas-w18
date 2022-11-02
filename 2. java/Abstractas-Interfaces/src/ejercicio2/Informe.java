package ejercicio2;

public class Informe extends Libro{

    private String texto;
    private Persona revisor;

    public Informe(int cantidadPaginas, Persona autor, String texto, Persona revisor) {
        super(cantidadPaginas, autor);
        this.texto=texto;
        this.revisor=revisor;
    }

    public String getTexto() {
        return texto;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }

    public String imprimirContenido(){
        return super.imprimirContenido()+", Revisor: "+revisor.toString()+" , Texto: "+texto;
    }
}
