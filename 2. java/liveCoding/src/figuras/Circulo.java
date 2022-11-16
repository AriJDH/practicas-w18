package figuras;

public class Circulo extends FigurasGeometricas{
    private int radio;

    public Circulo(int posX, int posY, int radio) {
        super(posX, posY);
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(getRadio(), 2);
    }
}
