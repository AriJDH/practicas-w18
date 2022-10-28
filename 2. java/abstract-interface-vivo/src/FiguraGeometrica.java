public abstract class FiguraGeometrica {
    private final int posX;
    private final int posY;

    public FiguraGeometrica(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public abstract double calcularArea();
}
