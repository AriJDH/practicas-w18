public class PracticaExcepciones {
    int a=0;
    int b=300;

    public void dividir(){
        try{
            if(a ==0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            double res = b/a;
        }
        catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }
        finally{
            System.out.println("Programa finalizado");
        }
    }

}
