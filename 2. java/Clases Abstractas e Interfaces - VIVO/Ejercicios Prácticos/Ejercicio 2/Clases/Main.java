public class Main {

    public static void main(String[] args){

        //Casos de prueba
        String habilidades[] = {"Proactico","Creativo","Analitico"};
        Curriculums CV = new Curriculums("Juan", 31, "30.123.442", habilidades);
        Impresora.imprimir(CV);

        LibrosPDF PDF = new LibrosPDF(5, "J. K Rowling", "Las maravillas del mas alla", "Fantasia");
        Impresora.imprimir(PDF);

        Informes Excel = new Informes(10, 20, "Eloy", "Microsoft");
        Impresora.imprimir(Excel);


    }

}
