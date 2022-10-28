import clases.Curriculum;
import clases.Documento;
import clases.Informe;
import clases.LibroPDF;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Documento> documentos = new ArrayList<>();

        documentos.add(new Curriculum());
        documentos.add(new Informe());
        documentos.add(new LibroPDF());

        for (Documento docum: documentos
             ) {
            docum.imprimir(docum);
        }

        }
    }
