package LiveCodingIntefaceClassAbs;

public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Triangulo(int posx, int posy, int base, int altura) {
        super(posx, posy);
        this.base = base;
        this.altura = altura;
    }

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    public double imprimirbase(){
        return this.base;
    }
}
