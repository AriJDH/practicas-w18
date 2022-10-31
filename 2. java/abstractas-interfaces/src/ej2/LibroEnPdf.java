package ej2;

public class LibroEnPdf extends Documento {
    int cant_paginas;
    String autor;
    String titulo;
    String genero;

    @Override
    public String toString() {
        return "LibroEnPdf{" +
                "cant_paginas=" + cant_paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    public LibroEnPdf(int cant_paginas, String autor, String titulo, String genero) {
        this.cant_paginas = cant_paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

}

