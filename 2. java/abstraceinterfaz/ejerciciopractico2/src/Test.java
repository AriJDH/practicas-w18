import java.util.Collections;mport java.util.Collections;

public class Test {
    public String identificaDocumento(Object o) {
        String tipoDocumento = null;
        if(o instanceof  Curriculums){
            tipoDocumento = "Curriculums";
        }else if(o instanceof  Informes) {
            tipoDocumento = "Informes";
        }else if(o instanceof LibrosPDF){
            tipoDocumento = "Libros PDF";
        }
        return tipoDocumento;
    }
    public static void main(String[] args) {
        Curriculums curriculums = new Curriculums("Janeth", "Martinez", "Lucio", Collections.singletonList(("Retos")));
        Test test = new Test();
        String temDocumento = test.identificaDocumento(curriculums);
        curriculums.imprimirDocumento(temDocumento);
        System.out.println(curriculums.toString());

    }
}

