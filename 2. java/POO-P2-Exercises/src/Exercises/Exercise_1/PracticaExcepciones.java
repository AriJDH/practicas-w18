package Exercises.Exercise_1;

public class PracticaExcepciones {
  int a = 0;
  int b = 0;

  public PracticaExcepciones(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public static void main(String[] args) {
    PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0, 10);
    practicaExcepciones.calculateQuotient();
  }

  public void calculateQuotient() {
    try {
      int cociente = this.b / this.a;
       System.out.println("result is: " + cociente);
    } catch (ArithmeticException e) {
      System.out.println("No se puede dividir por cero");
    } finally {
      System.out.println("Programa finalizado");
    }
  }
}
