public class PracticaExcepciones {

    public static int a = 0;
    public static  int b = 300;

    public static void main(String[] args) {

        /****************** Apartado 1 ************************/
        System.out.println("Apartado 1: ");
        try{
            int cociente = b/a;
        }catch (ArithmeticException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

        /****************** Apartado 2 ************************/
        System.out.println("************************************");
        System.out.println("Apartado 2: ");
        dividir();

    }

    public static void dividir() {
        try {
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero.");
            }

        } catch (IllegalArgumentException exception){
            exception.printStackTrace();
        }
    }

}
