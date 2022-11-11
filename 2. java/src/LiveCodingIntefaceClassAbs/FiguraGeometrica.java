package LiveCodingIntefaceClassAbs;

public abstract class FiguraGeometrica {
    private int posx;
    private int posy;

    public FiguraGeometrica(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public FiguraGeometrica() {
    }

    public abstract double calcularArea();
}
