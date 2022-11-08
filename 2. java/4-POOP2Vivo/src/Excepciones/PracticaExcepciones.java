package Excepciones;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public PracticaExcepciones() {
    }

        public PracticaExcepciones(int a,
                               int b) {
        this.a = a;
        this.b = b;
    }

    public double calcular() throws ArithmeticException {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return b / a;
    }
}
