package figuras;

public abstract class FigurasGeometricas {
    private int posX;
    private int posY;

    public FigurasGeometricas(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract  double calcularArea();
}
