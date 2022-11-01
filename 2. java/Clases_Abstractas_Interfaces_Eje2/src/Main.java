public class Main {

    public static void main(String[] args) {
        String[] habilidades = new String[]{"Python, Java, SQL, Spring, Unit test"};
        Curriculum hoja_vida = new Curriculum("Andres",23,"3214786984",habilidades);
        Informe informe = new Informe(14,"Pedro","Jose","este es mi informe sobre la mineria");
        Libro_PDF libroPdf = new Libro_PDF(225,"Manuel","Como hablar aleman","Idiomas");

        Imprimible.imprimir(hoja_vida);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(libroPdf);
    }

}
