package example;

public abstract class FiguraGeometrica {
  private int posX;
  private int posY;

  public FiguraGeometrica(int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
  }

  public abstract double calcularArea();
}
