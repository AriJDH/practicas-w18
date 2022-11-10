package example;

public class Triangulo extends FiguraGeometrica {
  private double altura;
  private double base;

  public Triangulo(int posX, int posY, double base, double altura) {
    super(posX, posY);
    this.base = base;
    this.altura = altura;
  }

  @Override
  public double calcularArea() {
    
    return (base * altura) / 2;
  }
}
