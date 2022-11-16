package figuras;

public class Triangulo extends FigurasGeometricas {
    private double base;
    private double altura;

    public Triangulo(int posX, int posY) {
        super(posX, posY);
    }

    public Triangulo(int posX, int posY, double base, double altura) {
        super(posX, posY);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return ((getBase() * getAltura())/2);
    }
}
