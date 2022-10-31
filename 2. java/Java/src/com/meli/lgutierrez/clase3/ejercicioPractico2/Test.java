package com.meli.lgutierrez.clase3.ejercicioPractico2;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        TipoDocumento informe = new Informe(50, 5, "Laura", "Jhon");
        informe.imprimir(informe);

        List<String> habilidades = new ArrayList<>();
        habilidades.add("Responsable");
        habilidades.add("Paciente");

        TipoDocumento curriculo = new Curriculo(new Persona("Cecilia", 123456), habilidades);
        curriculo.imprimir(curriculo);

        TipoDocumento libro = new LibrosPDF(376, "J. K Rowling", "Harry Potter","Fantasía");
        libro.imprimir(libro);
    }
}
