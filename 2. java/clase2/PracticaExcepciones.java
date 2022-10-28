package clase2;

public class PracticaExcepciones
{

    public float dividir(int a, int b) throws ArithmeticException
    {
        if (b == 0)
            throw new ArithmeticException("No se puede dividir por cero");
        return a / b;
    }

    public static void main(String[] args) {

        PracticaExcepciones pe = new PracticaExcepciones();
        try {
            float resultado = pe.dividir(10, 0);
            System.out.println("resultado: "+resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

}

