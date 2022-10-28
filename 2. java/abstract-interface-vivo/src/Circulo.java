public class Circulo extends FiguraGeometrica {
    private int radio;

    public Circulo(int posX, int posY) {
        super(posX, posY);
    }

    public Circulo(int posX, int posY, int radio) {
        super(posX, posY);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }

    public String testingC() {
        return "Other circle method";
    }
}
