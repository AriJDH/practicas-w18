package LiveCodingIntefaceClassAbs;

public class Circulo extends FiguraGeometrica{
    private float radio;

    public Circulo(int posx, int posy, float radio) {
        super(posx, posy);
        this.radio = radio;
    }

    public Circulo(float radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * (radio*radio);
    }


}
