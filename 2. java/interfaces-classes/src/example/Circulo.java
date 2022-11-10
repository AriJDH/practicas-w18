package example;

public class Circulo extends FiguraGeometrica {
  private float radio;

  public Circulo(int posicionX, int posicionY, float radio) {
    super(posicionX, posicionY);
    this.radio = radio;
  }

  public void testNotPossible() {
    System.out.println("this is not possible");
  }

  @Override
  public double calcularArea() {
    return Math.PI * (radio * radio);
  }
}
