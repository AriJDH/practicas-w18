package excepciones;

public class PracticaExcepciones {
    private int a= 0;
    private int b= 300;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        int num1 = pe.getA();
        int num2 = pe.getB();
        try{
            if (num1==0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            System.out.println(num2/num1);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado!");
        }
    }

}
