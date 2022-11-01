package ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos;

public class LibroPDF extends Documento {
    int cant_paginas;
    String autor;
    String titulo;
    String genero;

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cant_paginas=" + cant_paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public LibroPDF(int cant_paginas, String autor, String titulo, String genero) {
        this.cant_paginas = cant_paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

}
