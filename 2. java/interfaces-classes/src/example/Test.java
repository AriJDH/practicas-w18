package example;

public class Test {

  public static void main(String[] args) {
    FiguraGeometrica f = new Triangulo(1, 2, 3, 7);
    System.out.println("FIGURA: El area del triangulo es: " + f.calcularArea());

    Circulo c = new Circulo(1, 2, 5);
    System.out.println("El area del circulo es: " + c.calcularArea());

    f = new Circulo(1, 2, 5);
    System.out.println("FIGURA: El area del circulo es: " + f.calcularArea());

    // f.testNotPossible(); -> Deben estar los metodos dentro de la clase padre abstracta
  }
}
