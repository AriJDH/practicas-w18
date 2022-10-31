package clases;

import Interface.Imprimible;
import superclase.Archivo;

public class Informe extends Archivo  {

    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informe(int cantidadPaginas, String autor, String revisor, String texto) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    //texto con n longitud??
    private String texto;

    @Override
    public String toString() {
        return "Informe{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
