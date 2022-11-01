package ClasesAbstractas_e_Interfaces.Ejercicio2.Documentos;

public class Informe extends Documento {
    String texto;
    int cant_paginas;
    String autor;
    String revisor;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", cant_paginas=" + cant_paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    public Informe(String texto, int cant_paginas, String autor, String revisor) {
        this.texto = texto;
        this.cant_paginas = cant_paginas;
        this.autor = autor;
        this.revisor = revisor;
    }
}
