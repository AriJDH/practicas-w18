public class Main {

    public static void main(String[] args) {

        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();

        try{
            practicaExcepciones.calcular();
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage("Error"));

        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Se ha producido un error");
        } finally{
            System.out.println("Programa Finalizado");
        }
    }
}
