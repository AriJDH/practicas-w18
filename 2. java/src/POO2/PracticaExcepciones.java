package POO2;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void dividir(){
        try{
            double resultado = this.a / this.b;
            if (b == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
        }
        catch (Exception ex){
            System.out.printf("Se ha producido un error");
        }
        finally {
            System.out.printf("Programa finalizado");
        }
    }
}


