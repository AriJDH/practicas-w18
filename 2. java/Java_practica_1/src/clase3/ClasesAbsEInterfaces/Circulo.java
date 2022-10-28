package clase3.ClasesAbsEInterfaces;

public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(int posX, int posY) {
        super(posX, posY);
    }

    public Circulo(int posX, int posY, double radio) {
        super(posX, posY);
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    public String otroMetodo2(){
        return "Otro método desde el círculo";
    }
}
